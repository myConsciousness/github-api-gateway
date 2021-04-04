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
import org.thinkit.api.gateway.github.response.repos.Repository;
import org.thinkit.api.gateway.github.user.GithubUser;
import org.thinkit.api.gateway.github.user.OAuthConfig;
import org.thinkit.api.gateway.github.util.CommunicationResolver;

import lombok.NonNull;

final class GithubRepositoryApi extends AbstractApi implements RepositoryApi {

    /**
     * The communicate resolver
     */
    private CommunicationResolver communicationResolver;

    /**
     * The defalut per page
     */
    private int defaultPerPage;

    /**
     * The constructor. This constructor does configure OAuth authentication.
     *
     * @param githubUser  The GitHub user
     * @param oAuthConfig The OAuth config
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    private GithubRepositoryApi(@NonNull final GithubUser githubUser, @NonNull final OAuthConfig oAuthConfig) {
        super(githubUser);
        this.communicationResolver = CommunicationResolver.from(oAuthConfig);
    }

    /**
     * Returns the new instance of {@link GithubApiGateway} based on the argument.
     *
     * @param githubUser  The GitHub user
     * @param oAuthConfig The OAuth config
     * @return The new instance of {@link GithubApiGateway}
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static RepositoryApi from(@NonNull final GithubUser githubUser, @NonNull final OAuthConfig oAuthConfig) {
        return new GithubRepositoryApi(githubUser, oAuthConfig);
    }

    @Override
    public List<Repository> getRepositories(@NonNull final String repositoryDomain) {
        return this.communicationResolver.getAsList(super.createUrl(GithubApi.REPOSITORY, List.of(repositoryDomain)),
                Repository.class);
    }
}
