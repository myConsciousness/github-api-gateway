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

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 *
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UrlResolver {

    public static GenericUrl createUrl(@NonNull final GithubApi githubApi) {
        return createUrl(githubApi, new HashMap<>(0), new ArrayList<>(0));
    }

    public static GenericUrl createUrl(@NonNull final GithubApi githubApi, @NonNull final List<String> binds) {
        return createUrl(githubApi, new HashMap<>(0), binds);
    }

    public static GenericUrl createUrl(@NonNull final GithubApi githubApi,
            @NonNull final Map<QueryKey, Object> queries) {
        return createUrl(githubApi, queries, new ArrayList<>(0));
    }

    public static GenericUrl createUrl(@NonNull final GithubApi githubApi, @NonNull final Map<QueryKey, Object> queries,
            @NonNull final List<String> binds) {

        if (queries.isEmpty()) {
            return new GenericUrl(bind(githubApi, binds));
        }

        final StringJoiner queryJoiner = new StringJoiner("&");

        queries.forEach((key, value) -> {
            final StringBuilder query = new StringBuilder();
            query.append(key.getTag()).append("=").append(key);
            queryJoiner.add(query.toString());
        });

        return new GenericUrl(new StringJoiner("?").add(bind(githubApi, binds)).add(queryJoiner.toString()).toString());
    }

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
