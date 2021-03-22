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
import java.util.List;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor(staticName = "newInstance")
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

    public <T> T get(@NonNull final GenericUrl genericUrl) {
        return null;
    }

    public <T> List<T> getAsList(@NonNull final GenericUrl genericUrl) {
        try {
            return this.parseAsList(this.sendGetRequest(genericUrl));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private HttpResponse sendGetRequest(@NonNull final GenericUrl genericUrl) throws IOException {
        final HttpRequest httpRequest = HTTP_REQUEST_FACTORY.buildGetRequest(genericUrl);
        return httpRequest.setParser(JSON_OBJECT_PARSER).execute();
    }

    // @SuppressWarnings("unchecked")
    // private <T> T parseAs(@NonNull final HttpResponse httpResponse) throws
    // IOException {
    // return (T) httpResponse.parseAs(T.class);
    // }

    @SuppressWarnings("unchecked")
    private <T> List<T> parseAsList(@NonNull final HttpResponse httpResponse) throws IOException {
        return (List<T>) httpResponse.parseAs(TypeTokenResolver.getListToken());
    }
}
