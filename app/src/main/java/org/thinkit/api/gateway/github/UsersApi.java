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

import org.thinkit.api.gateway.github.response.user.User;
import org.thinkit.api.gateway.github.response.user.followers.UserFollower;
import org.thinkit.api.gateway.github.response.user.following.FollowingUser;
import org.thinkit.api.gateway.github.response.user.receivedevents.ReceivedEvent;
import org.thinkit.api.gateway.github.response.user.repos.UserRepository;
import org.thinkit.api.gateway.github.response.user.subscriptions.UserSubscription;

public interface UsersApi {

    /**
     * Returns the specific user information through the GitHub API {@code
     * https://api.github.com/users/username}.
     *
     * @return The user information
     */
    public User getUser();

    /**
     * Returns the specific user's following information through the GitHub API
     * {@code https://api.github.com/users/username/following}.
     *
     * @return The user's following information
     */
    public List<FollowingUser> getFollowingUsers();

    /**
     * Returns the specific user's following information through the GitHub API
     * {@code https://api.github.com/users/username/following?per_page=xxx}.
     *
     * @param perPage The page count
     * @return The specified number of user's following information
     */
    public List<FollowingUser> getFollowingUsers(final int perPage);

    /**
     * Returns the specific user's follower information through the GitHub API
     * {@code https://api.github.com/users/username/follower}.
     *
     * @return The user's follower information
     */
    public List<UserFollower> getUserFollowers();

    /**
     * Returns the specific user's follower information through the GitHub API
     * {@code https://api.github.com/users/username/follower?per_page=xxx}.
     *
     * @param perPage The page count
     * @return The specified number of user's follower information
     */
    public List<UserFollower> getUserFollowers(final int perPage);

    /**
     * Returns the specific user's repository information through the GitHub API
     * {@code https://api.github.com/users/username/repos}.
     *
     * @return The user's repository information
     */
    public List<UserRepository> getUserRepositories();

    /**
     * Returns the specific received events information through the GitHub API
     * {@code https://api.github.com/users/username/received_events}.
     *
     * @return The received events information
     */
    public List<ReceivedEvent> getReceivedEvents();

    /**
     * Returns the specific user's subscription information through the GitHub API
     * {@code https://api.github.com/users/username/subscriptions}.
     *
     * @return The specific user's subscription information
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public List<UserSubscription> getUserSubscriptions();
}
