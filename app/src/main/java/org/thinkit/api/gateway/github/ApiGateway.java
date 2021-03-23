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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * The abstract class that defines the generic processing for implementing the
 * GitHub API gateway.
 *
 * <p>
 * The {@link GithubUser} object must be set with the user information required
 * to call the API; if the user information required to call the API is not set,
 * the API call will fail or an exception will be thrown at runtime.
 *
 * <p>
 * It provides {@link #createUrl(GithubApi)} and
 * {@link #createUrl(GithubApi, Map)} methods to easily generate URLs for
 * calling the API.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public abstract class ApiGateway implements Gateway, Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 5408959112740655553L;

    /**
     * The GitHub user
     */
    @Getter(AccessLevel.PRIVATE)
    private GithubUser githubUser;

    /**
     * Generate the API URL based on the Enum element of {@link GithubApi} passed as
     * an argument. To specify a query string in the API URL, use
     * {@link #createUrl(GithubApi, Map)} .
     *
     * @param githubApi The GitHub API
     * @return The API URL
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    protected GenericUrl createUrl(@NonNull final GithubApi githubApi) {
        return this.createUrl(githubApi, new HashMap<>(0));
    }

    /**
     * Generate the API URL based on the Enum element of {@link GithubApi} and
     * queries map passed as arguments. If you do not need to specify a query string
     * in the API URL, use {@link #createUrl(GithubApi)} .
     *
     * @param githubApi The GitHub API
     * @param queries   The queries
     * @return The API URL
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    protected GenericUrl createUrl(@NonNull final GithubApi githubApi, @NonNull final Map<QueryKey, Object> queries) {

        return switch (githubApi) {
        case USER -> UrlResolver.createUrl(GithubApi.USER, List.of(this.getGithubUser().getUserName()));
        case USER_FOLLOWERS -> UrlResolver.createUrl(githubApi, queries, List.of(this.getGithubUser().getUserName()));
        case FOLLOWING_USER -> UrlResolver.createUrl(githubApi, queries, List.of(this.getGithubUser().getUserName()));
        };
    }
}
