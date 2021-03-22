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

import java.util.List;

import org.thinkit.api.gateway.github.catalog.GithubApi;
import org.thinkit.api.gateway.github.response.FollowingUser;
import org.thinkit.api.gateway.github.response.User;
import org.thinkit.api.gateway.github.response.UserFollower;
import org.thinkit.api.gateway.github.user.GithubUser;
import org.thinkit.api.gateway.github.util.CommunicationResolver;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "from")
public final class GithubApiGateway extends ApiGateway {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = -2391992718333265549L;

    /**
     * The GitHub User
     */
    @NonNull
    @Getter(AccessLevel.PROTECTED)
    private GithubUser githubUser;

    public User getUser() {
        return CommunicationResolver.newInstance().get(super.createUrl(GithubApi.USER));
    }

    public List<FollowingUser> getFollowingUsers() {
        return CommunicationResolver.newInstance().getAsList(super.createUrl(GithubApi.FOLLOWING_USER));
    }

    public List<FollowingUser> getFollowingUsers(final int perPage) {
        return CommunicationResolver.newInstance().getAsList(super.createUrl(GithubApi.FOLLOWING_USER));
    }

    public List<UserFollower> getUserFollowers() {
        return CommunicationResolver.newInstance().getAsList(super.createUrl(GithubApi.USER_FOLLOWERS));
    }

    public List<UserFollower> getUserFollowers(final int perPage) {
        return CommunicationResolver.newInstance().getAsList(super.createUrl(GithubApi.USER_FOLLOWERS));
    }
}
