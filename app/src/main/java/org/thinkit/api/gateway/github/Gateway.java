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

import org.thinkit.api.gateway.github.response.followers.UserFollower;
import org.thinkit.api.gateway.github.response.following.FollowingUser;
import org.thinkit.api.gateway.github.response.repos.UserRepository;
import org.thinkit.api.gateway.github.response.user.User;

/**
 * The interface that abstracts the gateway. It provides a gateway for intuitive
 * and easy access to the GitHub API.
 *
 * <p>
 * If you have an API that you want to use with the GitHub API, you can use this
 * interface without having to be aware of the various implementations and
 * mechanisms required for communication. As a user, all you need to be aware of
 * is to call each method defined in this interface and use the returned object.
 * The object returned from methods of this interface has the same structure and
 * items as the JSON data returned from each GitHub API.
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
public interface Gateway {

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
}
