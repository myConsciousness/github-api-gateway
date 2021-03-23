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
import java.util.Map;

import org.thinkit.api.gateway.github.catalog.GithubApi;
import org.thinkit.api.gateway.github.catalog.QueryKey;
import org.thinkit.api.gateway.github.response.followers.UserFollower;
import org.thinkit.api.gateway.github.response.following.FollowingUser;
import org.thinkit.api.gateway.github.response.user.User;
import org.thinkit.api.gateway.github.user.GithubUser;
import org.thinkit.api.gateway.github.util.CommunicationResolver;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * It provides a gateway for intuitive and easy access to the GitHub API.
 *
 * <p>
 * If you have an API that you want to use with the GitHub API, you can use this
 * interface without having to be aware of the various implementations and
 * mechanisms required for communication. As a user, all you need to be aware of
 * is to call each method defined in this class and use the returned object. The
 * object returned from methods of this class has the same structure and items
 * as the JSON data returned from each GitHub API.
 *
 * <p>
 * For example, if you want to get the follower information associated with a
 * particular user, you can call {@link #getUserFollowers()} like below.
 *
 * <pre>
 * <code>
 * final GithubUser githubUser = GithubUser.builder().userName("username").build();
 * final Gateway gateway = GithubApiGateway.from(githubUser);
 * final List<UserFollowers> userFollowers = gateway.getUserFollowers();
 * </code>
 * </pre>
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
public final class GithubApiGateway extends ApiGateway {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = -2391992718333265549L;

    /**
     * The constructor.
     *
     * @param githubUser The GitHub user
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    private GithubApiGateway(@NonNull final GithubUser githubUser) {
        super(githubUser);
    }

    /**
     * Returns the new instance of {@link GithubApiGateway} based on the argument.
     *
     * @param githubUser The GitHub user
     * @return The new instance of {@link GithubApiGateway}
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static Gateway from(@NonNull final GithubUser githubUser) {
        return new GithubApiGateway(githubUser);
    }

    @Override
    public User getUser() {
        return CommunicationResolver.newInstance().get(super.createUrl(GithubApi.USER), User.class);
    }

    @Override
    public List<FollowingUser> getFollowingUsers() {
        return CommunicationResolver.newInstance().getAsList(super.createUrl(GithubApi.FOLLOWING_USER));
    }

    @Override
    public List<FollowingUser> getFollowingUsers(final int perPage) {
        return CommunicationResolver.newInstance()
                .getAsList(super.createUrl(GithubApi.FOLLOWING_USER, Map.of(QueryKey.PER_PAGE, perPage)));
    }

    @Override
    public List<UserFollower> getUserFollowers() {
        return CommunicationResolver.newInstance().getAsList(super.createUrl(GithubApi.USER_FOLLOWERS));
    }

    @Override
    public List<UserFollower> getUserFollowers(final int perPage) {
        return CommunicationResolver.newInstance()
                .getAsList(super.createUrl(GithubApi.USER_FOLLOWERS, Map.of(QueryKey.PER_PAGE, perPage)));
    }
}
