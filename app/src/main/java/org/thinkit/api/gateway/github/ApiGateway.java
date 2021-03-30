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
import java.util.ArrayList;
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
 * It provides {@link #createUrl(GithubApi)} ,
 * {@link #createUrl(GithubApi, Map)} , {@link #createUrl(GithubApi, List)} and
 * {@link #createUrl(GithubApi, Map, List)} methods to easily generate URLs for
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
    protected GithubUser githubUser;

    /**
     * Generate the API URL based on the Enum element of {@link GithubApi} passed as
     * an argument.
     *
     * @param githubApi The GitHub API
     * @return The API URL
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    protected GenericUrl createUrl(@NonNull final GithubApi githubApi) {
        return this.createUrl(githubApi, new HashMap<>(0), new ArrayList<>(0));
    }

    /**
     * Generate the API URL based on the Enum element of {@link GithubApi} and
     * request queries passed as arguments.
     *
     * @param githubApi The GitHub API
     * @param queries   The queries
     * @return The GitHub API
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    protected GenericUrl createUrl(@NonNull final GithubApi githubApi, @NonNull final Map<QueryKey, Object> queries) {
        return this.createUrl(githubApi, queries, new ArrayList<>(0));
    }

    /**
     * Generate the API URL based on the Enum element of {@link GithubApi} and bind
     * items passed as arguments.
     *
     * @param githubApi The GitHub API
     * @param binds     The bind items
     * @return The API URL
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    protected GenericUrl createUrl(@NonNull final GithubApi githubApi, @NonNull final List<String> binds) {
        return this.createUrl(githubApi, new HashMap<>(0), binds);
    }

    /**
     * Generate the API URL based on the Enum element of {@link GithubApi} , request
     * queries and bind items passed as arguments.
     *
     * @param githubApi The GitHub API
     * @param queries   The request queries
     * @param binds     The bind items
     * @return The API URL
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    protected GenericUrl createUrl(@NonNull final GithubApi githubApi, @NonNull final Map<QueryKey, Object> queries,
            @NonNull final List<String> binds) {
        return UrlResolver.createUrl(githubApi, queries, this.mergeBinds(binds));
    }

    /**
     * Merges the bind list passed as an argument with the GitHub user information.
     *
     * @param binds The original bind items
     * @return The merged binds
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    private List<String> mergeBinds(@NonNull final List<String> binds) {

        final List<String> mergedBinds = new ArrayList<>(0);
        mergedBinds.add(this.githubUser.getUserName());

        binds.forEach(bind -> {
            mergedBinds.add(bind);
        });

        return mergedBinds;
    }
}
