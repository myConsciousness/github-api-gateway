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
import org.thinkit.api.gateway.github.response.repos.Repository;
import org.thinkit.api.gateway.github.user.GithubUser;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
final class GithubRepositoryApi extends AbstractApi implements RepositoryApi {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = -4821784961746219516L;

    private GithubRepositoryApi(@NonNull final GithubUser githubUser,
            @NonNull final DefaultQueryParameter defaultQueryParameter, @NonNull final Communicator communicator) {
        super(githubUser, defaultQueryParameter, communicator);
    }

    public static RepositoryApi from(@NonNull final GithubUser githubUser,
            @NonNull final DefaultQueryParameter defaultQueryParameter, @NonNull final Communicator communicator) {
        return new GithubRepositoryApi(githubUser, defaultQueryParameter, communicator);
    }

    @Override
    public List<Repository> getRepositories(@NonNull final String repositoryDomain) {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.REPOSITORY, List.of(repositoryDomain)),
                Repository.class);
    }
}
