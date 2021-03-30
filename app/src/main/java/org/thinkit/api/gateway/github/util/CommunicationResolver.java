/*
 * Copyright 2021 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.thinkit.api.gateway.github.util;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;

import org.thinkit.api.catalog.BiCatalog;
import org.thinkit.api.gateway.github.catalog.ErrorHttpStatus;
import org.thinkit.api.gateway.github.exception.AccessForbiddenException;
import org.thinkit.api.gateway.github.exception.BadGatewayException;
import org.thinkit.api.gateway.github.exception.BadRequestException;
import org.thinkit.api.gateway.github.exception.InternalServerErrorException;
import org.thinkit.api.gateway.github.exception.NotAcceptableException;
import org.thinkit.api.gateway.github.exception.NotFoundException;
import org.thinkit.api.gateway.github.exception.ServiceUnavailableException;
import org.thinkit.api.gateway.github.exception.UserUnauthorizedException;
import org.thinkit.api.gateway.github.user.OAuthConfig;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * The class that provides general-purpose processing for HTTP communication.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "from")
public final class CommunicationResolver implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 294272078327803469L;

    /**
     * The http request factory
     */
    private static final HttpRequestFactory HTTP_REQUEST_FACTORY = (new NetHttpTransport()).createRequestFactory();

    /**
     * The JSON object parser
     */
    private static final JsonObjectParser JSON_OBJECT_PARSER = new JsonObjectParser(GsonFactory.getDefaultInstance());

    /**
     * The OAuth config
     */
    private OAuthConfig oAuthConfig;

    /**
     * Sends a Get request to the request URL.
     *
     * <p>
     * The response will be parsed into the response type specified as the second
     * argument and returned.
     *
     * @param <T>           The response type
     * @param genericUrl    The request url object
     * @param responseClass The response class
     * @return The JSON response
     *
     * @exception NullPointerException if {@code null} is passed as an argument
     */
    public <T> T get(@NonNull final GenericUrl genericUrl, @NonNull final Class<T> responseClass) {
        try {
            return this.parseAs(this.sendGetRequest(genericUrl), responseClass);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Sends a Get request to the request URL.
     *
     * <p>
     * The response will be parsed into the list of response type specified as the
     * second argument and returned.
     *
     * @param <T>           The response type
     * @param genericUrl    The request url object
     * @param responseClass The response class
     * @return The JSON responses as list
     *
     * @exception NullPointerException if {@code null} is passed as an argument
     */
    public <T> List<T> getAsList(@NonNull final GenericUrl genericUrl, @NonNull final Class<T> responseClass) {
        try {
            return this.parseAsList(this.sendGetRequest(genericUrl), ListGenericResolver.of(responseClass));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Sends a GET request to the URL set in the URL object passed as an argument.
     *
     * @param genericUrl The API URL
     * @return The HTTP response
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     * @throws IOException If an error occurs during HTTP communication
     */
    private HttpResponse sendGetRequest(@NonNull final GenericUrl genericUrl) throws IOException {
        final HttpRequest httpRequest = HTTP_REQUEST_FACTORY.buildGetRequest(genericUrl);
        httpRequest.getHeaders().setAuthorization(SecuritySchemeResolver.bearer(this.oAuthConfig.getAccessToken()));
        return this.checkHttpStatus(httpRequest.setParser(JSON_OBJECT_PARSER).execute());
    }

    /**
     * Parses the HTTP response into the type specified as an argument.
     *
     * @param <T>           The response type
     * @param httpResponse  The http response
     * @param responseClass The response class
     * @return The JSON response as the response type specified as the argument
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     * @throws IOException If an error occurs during parsing
     */
    private <T> T parseAs(@NonNull final HttpResponse httpResponse, @NonNull final Class<T> responseClass)
            throws IOException {
        return (T) httpResponse.parseAs(responseClass);
    }

    /**
     * Parses the HTTP response into list of the type specified as an argument.
     *
     * @param <T>               The response type
     * @param httpResponse      The http response
     * @param parameterizedType The parameterized type of response class
     * @return The JSON responses as the list of response type specified as the
     *         argument
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     * @throws IOException If an error occurs during parsing
     */
    @SuppressWarnings("unchecked")
    private <T> List<T> parseAsList(@NonNull final HttpResponse httpResponse,
            @NonNull final ParameterizedType parameterizedType) throws IOException {
        return (List<T>) httpResponse.parseAs(parameterizedType);
    }

    /**
     * Check the status code of the HTTP response.
     *
     * <p>
     * The exception will always be raised at runtime if a status code indicating a
     * client error and a server error is detected. If no error is detected, the
     * HTTP response passed as an argument will be returned as is.
     *
     * @param httpResponse The http response
     * @return The http response passed as an argument
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    private HttpResponse checkHttpStatus(@NonNull final HttpResponse httpResponse) {

        final ErrorHttpStatus errorHttpStatus = BiCatalog.getEnumByTag(ErrorHttpStatus.class,
                httpResponse.getStatusCode());

        if (errorHttpStatus == null) {
            return httpResponse;
        }

        switch (errorHttpStatus) {
        case BAD_REQUEST -> throw new BadRequestException(this.getStatusMessage(httpResponse));
        case UNAUTHORIZED -> throw new UserUnauthorizedException(this.getStatusMessage(httpResponse));
        case FORBIDDEN -> throw new AccessForbiddenException(this.getStatusMessage(httpResponse));
        case NOT_FOUND -> throw new NotFoundException(this.getStatusMessage(httpResponse));
        case NOT_ACCEPTABLE -> throw new NotAcceptableException(this.getStatusMessage(httpResponse));
        case INTERNAL_SERVER_ERROR -> throw new InternalServerErrorException(this.getStatusMessage(httpResponse));
        case BAD_GATEWAY -> throw new BadGatewayException(this.getStatusMessage(httpResponse));
        case SERVICE_UNAVAILABLE -> throw new ServiceUnavailableException(this.getStatusMessage(httpResponse));
        default -> throw new IllegalStateException(); // it will never happen
        }
    }

    /**
     * Returns the http status message from HTTP response.
     *
     * @param httpResponse The HTTP response
     * @return The HTTP status message
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    private String getStatusMessage(@NonNull final HttpResponse httpResponse) {
        return httpResponse.getStatusMessage();
    }
}
