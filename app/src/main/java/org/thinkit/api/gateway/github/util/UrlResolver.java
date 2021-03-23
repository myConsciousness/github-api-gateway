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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import com.google.api.client.http.GenericUrl;

import org.thinkit.api.gateway.github.catalog.GithubApi;
import org.thinkit.api.gateway.github.catalog.QueryKey;
import org.thinkit.api.gateway.github.catalog.QuerySymbol;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * The class that provides the URL generation process.
 *
 * <p>
 * It provides methods for several patterns in generating URLs. For example, if
 * you do not need to bind specific information to the API URL or specify a
 * query string, you can simply call {@link #createUrl(GithubApi)} to get the
 * URL object for calling the API.
 *
 * <p>
 * If you need to bind specific information to an API URL, call
 * {@link #createUrl(GithubApi, List)} , or if you need to specify a query
 * string for an API URL, call {@link #createUrl(GithubApi, Map)} . If you want
 * to bind specific information to the URL and also specify a query string, call
 * {@link #createUrl(GithubApi, Map, List)} .
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UrlResolver {

    /**
     * Returns an API URL object based on the Enum element of {@link GithubApi}
     * passed as an argument.
     *
     * @param githubApi The GitHub API
     * @return The API URL
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static GenericUrl createUrl(@NonNull final GithubApi githubApi) {
        return createUrl(githubApi, new HashMap<>(0), new ArrayList<>(0));
    }

    /**
     * Returns an API URL object based on the Enum element of {@link GithubApi} and
     * bind data passed as arguments.
     *
     * <p>
     * The bind data passed as an argument will be replaced with the string defined
     * as {@code "%s"} in the API URL using {@link String#format(String, Object...)}
     * .
     *
     * @param githubApi The GitHub API
     * @param binds     The bind data
     * @return The API URL
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static GenericUrl createUrl(@NonNull final GithubApi githubApi, @NonNull final List<String> binds) {
        return createUrl(githubApi, new HashMap<>(0), binds);
    }

    /**
     * Returns an API URL object based on the Enum element of {@link GithubApi} and
     * query data passed as arguments.
     *
     * <p>
     * The query data defined in the Map will be generated in the format
     * {@code ?key1=value1&key2=value2&...} .
     *
     * @param githubApi The GitHub API
     * @param queries   The query data
     * @return The API URL
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static GenericUrl createUrl(@NonNull final GithubApi githubApi,
            @NonNull final Map<QueryKey, Object> queries) {
        return createUrl(githubApi, queries, new ArrayList<>(0));
    }

    /**
     * Returns an API URL object based on the Enum element of {@link GithubApi} and
     * query data and bind data passed as arguments.
     *
     * <p>
     * The query data defined in the Map will be generated in the format
     * {@code ?key1=value1&key2=value2&...} .
     *
     * <p>
     * The bind data passed as an argument will be replaced with the string defined
     * as {@code "%s"} in the API URL using {@link String#format(String, Object...)}
     * .
     *
     * @param githubApi The GitHub API
     * @param queries   The query data
     * @param binds     The bind data
     * @return The API URL
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static GenericUrl createUrl(@NonNull final GithubApi githubApi, @NonNull final Map<QueryKey, Object> queries,
            @NonNull final List<String> binds) {

        if (queries.isEmpty()) {
            return new GenericUrl(bind(githubApi, binds));
        }

        final StringJoiner queryJoiner = new StringJoiner(QuerySymbol.AMPERSAND.getTag());
        final String equal = QuerySymbol.EQUAL.getTag();

        queries.forEach((key, value) -> {
            final StringBuilder query = new StringBuilder();
            query.append(key.getTag()).append(equal).append(key);
            queryJoiner.add(query.toString());
        });

        final StringJoiner urlJoiner = new StringJoiner(QuerySymbol.QUESTION.getTag()).add(bind(githubApi, binds))
                .add(queryJoiner.toString());

        return new GenericUrl(urlJoiner.toString());
    }

    /**
     * Replace and return the bind data passed as argument with the {@code "%s"}
     * string defined in the API URL. If the bind data does not exist, it returns
     * the string defined in the Enum element of {@link GithubApi} .
     *
     * @param githubApi The GitHub API
     * @param binds     The bind data
     * @return The binded url, or raw url if the bind data does not exist
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    private static String bind(@NonNull final GithubApi githubApi, @NonNull final List<String> binds) {

        if (binds.isEmpty()) {
            return githubApi.getTag();
        }

        String bindedUrl = githubApi.getTag();

        for (final String bindSequence : binds) {
            bindedUrl = String.format(bindedUrl, bindSequence);
        }

        return bindedUrl;
    }
}
