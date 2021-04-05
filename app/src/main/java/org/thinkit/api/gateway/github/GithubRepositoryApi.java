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
import org.thinkit.api.gateway.github.response.repos.Repository;
import org.thinkit.api.gateway.github.response.repos.issues.Issue;
import org.thinkit.api.gateway.github.response.repos.issues.comments.IssueComment;
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

    /**
     * The constructor.
     *
     * @param communicator          The http communicator
     * @param githubUser            The GitHub user
     * @param defaultQueryParameter The default query parameter
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    private GithubRepositoryApi(@NonNull final Communicator communicator, @NonNull final GithubUser githubUser,
            @NonNull final DefaultQueryParameter defaultQueryParameter) {
        super(communicator, githubUser, defaultQueryParameter);
    }

    /**
     * Returns the new instance of {@link GithubRepositoryApi} based on the
     * arguments.
     *
     * @param communicator          The http communicator
     * @param githubUser            The GitHub user
     * @param defaultQueryParameter The default query parameter
     * @return The new instance of {@link GithubRepositoryApi}
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static RepositoryApi from(@NonNull final Communicator communicator, @NonNull final GithubUser githubUser,
            @NonNull final DefaultQueryParameter defaultQueryParameter) {
        return new GithubRepositoryApi(communicator, githubUser, defaultQueryParameter);
    }

    @Override
    public List<Repository> getRepositories(@NonNull final String repositoryName) {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.REPOSITORY, List.of(repositoryName)),
                Repository.class);
    }

    @Override
    public List<Repository> getRepositories(@NonNull final String repositoryName,
            @NonNull final QueryParameter queryParameter) {
        return super.getCommunicator().getAsList(
                super.createUrl(GithubApi.REPOSITORY, queryParameter, List.of(repositoryName)), Repository.class);
    }

    @Override
    public List<Issue> getIssues(@NonNull String repositoryName) {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.ISSUES, List.of(repositoryName)),
                Issue.class);
    }

    @Override
    public List<Issue> getIssues(@NonNull String repositoryName, @NonNull QueryParameter queyParameter) {
        return super.getCommunicator()
                .getAsList(super.createUrl(GithubApi.ISSUES, queyParameter, List.of(repositoryName)), Issue.class);
    }

    @Override
    public List<IssueComment> getIssuesComments(@NonNull String repositoryName) {
        return super.getCommunicator().getAsList(super.createUrl(GithubApi.ISSUE_COMMENTS, List.of(repositoryName)),
                IssueComment.class);
    }

    @Override
    public List<IssueComment> getIssuesComments(@NonNull String repositoryName, @NonNull QueryParameter queyParameter) {
        return super.getCommunicator().getAsList(
                super.createUrl(GithubApi.ISSUE_COMMENTS, queyParameter, List.of(repositoryName)), IssueComment.class);
    }
}
