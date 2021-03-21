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

package org.thinkit.api.gateway.github;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.api.client.http.GenericUrl;

import org.thinkit.api.gateway.Gateway;
import org.thinkit.api.gateway.github.catalog.GithubApi;
import org.thinkit.api.gateway.github.user.GithubUser;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
public abstract class ApiGateway implements Gateway, Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 5408959112740655553L;

    protected abstract GithubUser getGithubUser();

    protected GenericUrl createUrl(@NonNull final GithubApi githubApiUri) {
        return this.createUrl(githubApiUri, new HashMap<>(0));
    }

    protected GenericUrl createUrl(@NonNull final GithubApi githubApiUri, @NonNull final Map<String, String> queries) {

        return switch (githubApiUri) {
        case USER -> new GenericUrl();
        case USER_FOLLOWERS -> new GenericUrl(String.format(githubApiUri.getTag(), this.getGithubUser().getUserName()));
        case FOLLOWING_USER -> new GenericUrl();
        };
    }
}
