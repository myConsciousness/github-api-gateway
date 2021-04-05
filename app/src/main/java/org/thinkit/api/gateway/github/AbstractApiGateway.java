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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.thinkit.api.gateway.github.catalog.GithubApi;
import org.thinkit.api.gateway.github.communication.Communicator;
import org.thinkit.api.gateway.github.communication.HttpCommunicator;
import org.thinkit.api.gateway.github.content.DefaultQueryParameterMapper;
import org.thinkit.api.gateway.github.content.entity.DefaultQueryParameter;
import org.thinkit.api.gateway.github.user.GithubUser;
import org.thinkit.api.gateway.github.user.OAuthConfig;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * The abstract class that defines the generic processing for implementing the
 * GitHub API gateway.
 *
 * <p>
 * The {@link GithubUser} object must be set with the user information required
 * to call the API; if the user information required to call the API is not set,
 * the API call will fail or an exception will be thrown at runtime.
 *
 * <p>
 * It provides {@link #createUrl(GithubApi)} ,
 * {@link #createUrl(GithubApi, Map)} , {@link #createUrl(GithubApi, List)} and
 * {@link #createUrl(GithubApi, Map, List)} methods to easily generate URLs for
 * calling the API.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class AbstractApiGateway implements Gateway, Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 5408959112740655553L;

    /**
     * The http communicator
     */
    @Getter(AccessLevel.PROTECTED)
    private Communicator communicator;

    /**
     * The GitHub user
     */
    @Getter(AccessLevel.PROTECTED)
    private GithubUser githubUser;

    /**
     * The default query parameter
     */
    @Getter(AccessLevel.PROTECTED)
    private DefaultQueryParameter defaultQueryParameter;

    /**
     * The constructor.
     *
     * @param githubUser The GitHub user
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    protected AbstractApiGateway(@NonNull final GithubUser githubUser) {
        this.githubUser = githubUser;
        this.defaultQueryParameter = DefaultQueryParameterMapper.newInstance().scan().get(0);
        this.communicator = HttpCommunicator.from(OAuthConfig.noneOf());
    }

    /**
     * The constructor.
     *
     * @param githubUser  The GitHub user
     * @param oAuthConfig The OAuth config
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    protected AbstractApiGateway(@NonNull final GithubUser githubUser, @NonNull final OAuthConfig oAuthConfig) {
        this.githubUser = githubUser;
        this.defaultQueryParameter = DefaultQueryParameterMapper.newInstance().scan().get(0);
        this.communicator = HttpCommunicator.from(oAuthConfig);
    }
}
