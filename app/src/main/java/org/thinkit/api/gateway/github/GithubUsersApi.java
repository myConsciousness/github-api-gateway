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
import org.thinkit.api.gateway.github.communication.CommunicationResolver;
import org.thinkit.api.gateway.github.response.user.User;
import org.thinkit.api.gateway.github.response.user.followers.UserFollower;
import org.thinkit.api.gateway.github.response.user.following.FollowingUser;
import org.thinkit.api.gateway.github.response.user.receivedevents.ReceivedEvent;
import org.thinkit.api.gateway.github.response.user.repos.UserRepository;
import org.thinkit.api.gateway.github.response.user.subscriptions.UserSubscription;
import org.thinkit.api.gateway.github.user.GithubUser;

import lombok.NonNull;

final class GithubUsersApi extends AbstractApi implements UsersApi {

    /**
     * The communicate resolver
     */
    private CommunicationResolver communicationResolver;

    /**
     * The defalut per page
     */
    private int defaultPerPage;

    /**
     * The constructor. This constructor does not configure OAuth authentication.
     *
     * @param githubUser The GitHub user
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    private GithubUsersApi(@NonNull final GithubUser githubUser) {
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
    public static UsersApi from(@NonNull final GithubUser githubUser) {
        return new GithubUsersApi(githubUser);
    }

    @Override
    public User getUser() {
        return this.communicationResolver.get(super.createUrl(GithubApi.USER), User.class);
    }

    @Override
    public List<FollowingUser> getFollowingUsers() {
        return this.getFollowingUsers(this.defaultPerPage);
    }

    @Override
    public List<FollowingUser> getFollowingUsers(final int perPage) {
        return this.communicationResolver.getAsList(
                super.createUrl(GithubApi.FOLLOWING_USER, Map.of(QueryKey.PER_PAGE, perPage)), FollowingUser.class);
    }

    @Override
    public List<UserFollower> getUserFollowers() {
        return this.getUserFollowers(this.defaultPerPage);
    }

    @Override
    public List<UserFollower> getUserFollowers(final int perPage) {
        return this.communicationResolver.getAsList(
                super.createUrl(GithubApi.USER_FOLLOWERS, Map.of(QueryKey.PER_PAGE, perPage)), UserFollower.class);
    }

    @Override
    public List<UserRepository> getUserRepositories() {
        return this.communicationResolver.getAsList(super.createUrl(GithubApi.USER_REPOSITORY), UserRepository.class);
    }

    @Override
    public List<ReceivedEvent> getReceivedEvents() {
        return this.communicationResolver.getAsList(super.createUrl(GithubApi.RECEIVED_EVENTS), ReceivedEvent.class);
    }

    @Override
    public List<UserSubscription> getUserSubscriptions() {
        return this.communicationResolver.getAsList(super.createUrl(GithubApi.USER_SUBSCRIPTIONS),
                UserSubscription.class);
    }
}
