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
import org.thinkit.api.gateway.github.communication.Communicator;
import org.thinkit.api.gateway.github.content.entity.DefaultQueryParameter;
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

@ToString
@EqualsAndHashCode(callSuper = false)
final class GithubUsersApi extends AbstractApi implements UsersApi {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 4444555790420425260L;

    private GithubUsersApi(@NonNull final GithubUser githubUser,
            @NonNull final DefaultQueryParameter defaultQueryParameter, @NonNull final Communicator communicator) {
        super(githubUser, defaultQueryParameter, communicator);
    }

    public static UsersApi from(@NonNull final GithubUser githubUser,
            @NonNull final DefaultQueryParameter defaultQueryParameter, @NonNull final Communicator communicator) {
        return new GithubUsersApi(githubUser, defaultQueryParameter, communicator);
    }

    @Override
    public User getUser() {
        return super.getCommunicator().get(super.createUrl(GithubApi.USER), User.class);
    }

    @Override
    public List<FollowingUser> getFollowingUsers() {
        return this.getFollowingUsers(100);
    }

    @Override
    public List<FollowingUser> getFollowingUsers(final int perPage) {
        return super.getCommunicator().getAsList(
                super.createUrl(GithubApi.FOLLOWING_USER, Map.of(QueryKey.PER_PAGE, perPage)), FollowingUser.class);
    }

    @Override
    public List<UserFollower> getUserFollowers() {
        return this.getUserFollowers(100);
    }

    @Override
    public List<UserFollower> getUserFollowers(final int perPage) {
        return super.getCommunicator().getAsList(
                super.createUrl(GithubApi.USER_FOLLOWERS, Map.of(QueryKey.PER_PAGE, perPage)), UserFollower.class);
    }

    @Override
    public List<UserRepository> getUserRepositories() {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.USER_REPOSITORY), UserRepository.class);
    }

    @Override
    public List<ReceivedEvent> getReceivedEvents() {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.RECEIVED_EVENTS), ReceivedEvent.class);
    }

    @Override
    public List<UserSubscription> getUserSubscriptions() {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.USER_SUBSCRIPTIONS), UserSubscription.class);
    }
}
