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

import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.thinkit.api.gateway.github.catalog.Delimiter;
import org.thinkit.api.gateway.github.catalog.SecurityScheme;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The class that provides the feature to resolve the security scheme name for
 * tokens.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class SecuritySchemeResolver {

    /**
     * Returns the token passed as an argument in the format with the bearer schema.
     *
     * @param token The token
     * @return The token with bearer scheme
     */
    public static String bearer(final String token) {

        if (StringUtils.isEmpty(token)) {
            return "";
        }

        final StringJoiner tokenJoiner = new StringJoiner(Delimiter.SPACE.getTag());
        tokenJoiner.add(SecurityScheme.BEARER.getTag());
        tokenJoiner.add(token);

        return tokenJoiner.toString();
    }
}
