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

package org.thinkit.api.gateway.github.communication;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.google.api.client.http.GenericUrl;

import org.thinkit.api.gateway.github.user.OAuthConfig;
import org.thinkit.api.gateway.github.util.ListGenericResolver;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * The class that provides general-purpose processing for HTTP communication.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
public final class HttpCommunicator extends AbstractHttpCommunicator implements Communicator, Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 294272078327803469L;

    private HttpCommunicator(@NonNull final OAuthConfig oAuthConfig) {
        super(oAuthConfig);
    }

    public static Communicator from(@NonNull final OAuthConfig oAuthConfig) {
        return new HttpCommunicator(oAuthConfig);
    }

    @Override
    public <T> T get(@NonNull final GenericUrl genericUrl, @NonNull final Class<T> responseClass) {
        try {
            return super.parseAs(super.sendGetRequest(genericUrl), responseClass);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public <T> List<T> getAsList(@NonNull final GenericUrl genericUrl, @NonNull final Class<T> responseClass) {
        try {
            return super.parseAsList(super.sendGetRequest(genericUrl), ListGenericResolver.of(responseClass));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
