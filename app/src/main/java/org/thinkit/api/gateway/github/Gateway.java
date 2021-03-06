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
 * particular user, you can call method like below.
 *
 * <pre>
 * <code>
 * final GithubUser githubUser = GithubUser.builder().userName("username").build();
 * final Gateway gateway = GithubApiGateway.from(githubUser);
 * final List&lt;UserFollowers&gt; userFollowers = gateway.getUsersApi().getUserFollowers();
 * </code>
 * </pre>
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
public interface Gateway {

    /**
     * Returns the GitHub users API.
     *
     * @return The GitHub users API
     */
    public UsersApi getUsersApi();

    /**
     * Returns the GitHub repository API.
     *
     * @return The GitHub repository API.
     */
    public RepositoryApi getRepositoryApi();
}
