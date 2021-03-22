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
import java.util.List;
import java.util.Map;

import com.google.api.client.http.GenericUrl;

import org.thinkit.api.gateway.github.catalog.GithubApi;
import org.thinkit.api.gateway.github.catalog.QueryKey;
import org.thinkit.api.gateway.github.user.GithubUser;
import org.thinkit.api.gateway.github.util.UrlResolver;

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

    /**
     * Returns the GitHub user object.
     *
     * @return The GitHub user object
     */
    protected abstract GithubUser getGithubUser();

    protected GenericUrl createUrl(@NonNull final GithubApi githubApi) {
        return this.createUrl(githubApi, new HashMap<>(0));
    }

    protected GenericUrl createUrl(@NonNull final GithubApi githubApi, @NonNull final Map<QueryKey, Object> queries) {

        return switch (githubApi) {
        case USER -> new GenericUrl();
        case USER_FOLLOWERS -> UrlResolver.createUrl(githubApi, queries, List.of(this.getGithubUser().getUserName()));
        case FOLLOWING_USER -> UrlResolver.createUrl(githubApi, queries, List.of(this.getGithubUser().getUserName()));
        };
    }
}
