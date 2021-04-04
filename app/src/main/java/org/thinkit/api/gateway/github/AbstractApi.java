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
import org.thinkit.api.gateway.github.communication.Communicator;
import org.thinkit.api.gateway.github.content.entity.DefaultQueryParameter;
import org.thinkit.api.gateway.github.user.GithubUser;
import org.thinkit.api.gateway.github.util.UrlResolver;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
abstract class AbstractApi implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 4065304436158915168L;

    /**
     * The GitHub user
     */
    @Getter(AccessLevel.PROTECTED)
    private GithubUser githubUser;

    /**
     * The default query parameter
     */
    @Getter(AccessLevel.PROTECTED)
    private DefaultQueryParameter defaultQueryParameter;

    /**
     * The http communicator
     */
    @Getter(AccessLevel.PROTECTED)
    private Communicator communicator;

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
