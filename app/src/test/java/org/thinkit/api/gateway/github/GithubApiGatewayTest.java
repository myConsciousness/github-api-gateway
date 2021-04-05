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

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.thinkit.api.gateway.github.response.user.following.FollowingUser;
import org.thinkit.api.gateway.github.user.GithubUser;
import org.thinkit.api.gateway.github.user.OAuthConfig;

/**
 * The class that manages test case of {@link GithubApiGateway} .
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
public final class GithubApiGatewayTest {

    /**
     * The access token
     */
    private static final String ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");

    /**
     * The gateway
     */
    private static final Gateway GATEWAY = GithubApiGateway.from(
            GithubUser.builder().userName("myConsciousness").build(),
            OAuthConfig.builder().accessToken(ACCESS_TOKEN).build());

    @Nested
    class TestGetUser {

        @Test
        void testResponseItems() {
            final List<FollowingUser> followingUsers = assertDoesNotThrow(
                    () -> GATEWAY.getUsersApi().getFollowingUsers());

            assertNotNull(followingUsers);

            final FollowingUser followingUser = followingUsers.get(0);

            assertNotNull(followingUser);
        }
    }
}
