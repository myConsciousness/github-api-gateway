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
import org.thinkit.api.gateway.github.communication.Communicator;
import org.thinkit.api.gateway.github.content.entity.DefaultQueryParameter;
import org.thinkit.api.gateway.github.query.QueryParameter;
import org.thinkit.api.gateway.github.response.user.User;
import org.thinkit.api.gateway.github.response.user.followers.UserFollower;
import org.thinkit.api.gateway.github.response.user.following.FollowingUser;
import org.thinkit.api.gateway.github.response.user.receivedevents.ReceivedEvent;
import org.thinkit.api.gateway.github.response.user.repos.UserRepository;
import org.thinkit.api.gateway.github.response.user.subscriptions.UserSubscription;
import org.thinkit.api.gateway.github.user.GithubUser;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
final class GithubUsersApi extends AbstractApi implements UsersApi {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 4444555790420425260L;

    /**
     * The constructor.
     *
     * @param communicator          The http communicator
     * @param githubUser            The GitHub user
     * @param defaultQueryParameter The default query parameter
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    private GithubUsersApi(@NonNull final Communicator communicator, @NonNull final GithubUser githubUser,
            @NonNull final DefaultQueryParameter defaultQueryParameter) {
        super(communicator, githubUser, defaultQueryParameter);
    }

    /**
     * Returns the new instance of {@link GithubUsersApi} based on the arguments.
     *
     * @param communicator          The http communicator
     * @param githubUser            The GitHub user
     * @param defaultQueryParameter The default query parameter
     * @return The new instance of {@link GithubUsersApi}
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static UsersApi from(@NonNull final Communicator communicator, @NonNull final GithubUser githubUser,
            @NonNull final DefaultQueryParameter defaultQueryParameter) {
        return new GithubUsersApi(communicator, githubUser, defaultQueryParameter);
    }

    @Override
    public User getUser() {
        return super.getCommunicator().get(super.createUrl(GithubApi.USER), User.class);
    }

    @Override
    public User getUser(@NonNull final QueryParameter queryParameter) {
        return super.getCommunicator().get(super.createUrl(GithubApi.USER, queryParameter), User.class);
    }

    @Override
    public List<FollowingUser> getFollowingUsers() {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.FOLLOWING_USER), FollowingUser.class);
    }

    @Override
    public List<FollowingUser> getFollowingUsers(@NonNull final QueryParameter queryParameter) {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.FOLLOWING_USER, queryParameter),
                FollowingUser.class);
    }

    @Override
    public List<UserFollower> getUserFollowers() {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.USER_FOLLOWERS), UserFollower.class);
    }

    @Override
    public List<UserFollower> getUserFollowers(@NonNull final QueryParameter queryParameter) {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.USER_FOLLOWERS, queryParameter),
                UserFollower.class);
    }

    @Override
    public List<UserRepository> getUserRepositories() {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.USER_REPOSITORY), UserRepository.class);
    }

    @Override
    public List<UserRepository> getUserRepositories(@NonNull final QueryParameter queryParameter) {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.USER_REPOSITORY, queryParameter),
                UserRepository.class);
    }

    @Override
    public List<ReceivedEvent> getReceivedEvents() {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.RECEIVED_EVENTS), ReceivedEvent.class);
    }

    @Override
    public List<ReceivedEvent> getReceivedEvents(@NonNull final QueryParameter queryParameter) {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.RECEIVED_EVENTS, queryParameter),
                ReceivedEvent.class);
    }

    @Override
    public List<UserSubscription> getUserSubscriptions() {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.USER_SUBSCRIPTIONS), UserSubscription.class);
    }

    @Override
    public List<UserSubscription> getUserSubscriptions(@NonNull final QueryParameter queryParameter) {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.USER_SUBSCRIPTIONS, queryParameter),
                UserSubscription.class);
    }
}
