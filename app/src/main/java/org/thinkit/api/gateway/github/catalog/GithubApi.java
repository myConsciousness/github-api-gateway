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

package org.thinkit.api.gateway.github.catalog;

import org.thinkit.api.catalog.BiCatalog;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The catalog that manages API of GitHub.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@RequiredArgsConstructor
public enum GithubApi implements BiCatalog<GithubApi, String> {

    /**
     * The API that retrieves specific user information
     */
    USER(0, "https://api.github.com/users/%s"),

    /**
     * The API that retrieves specific user's following information
     */
    FOLLOWING_USER(1, "https://api.github.com/users/%s/following"),

    /**
     * The API that retrieves specific user's followers information
     */
    USER_FOLLOWERS(2, "https://api.github.com/users/%s/followers"),

    /**
     * The API that retrieves specific user's repository information
     */
    USER_REPOSITORY(3, "https://api.github.com/users/%s/repos");

    /**
     * The code
     */
    @Getter
    private final int code;

    /**
     * The tag
     */
    @Getter
    private final String tag;
}
