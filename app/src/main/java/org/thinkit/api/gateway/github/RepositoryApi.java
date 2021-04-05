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

import org.thinkit.api.gateway.github.query.QueryParameter;
import org.thinkit.api.gateway.github.response.repos.Repository;
import org.thinkit.api.gateway.github.response.repos.issues.Issue;
import org.thinkit.api.gateway.github.response.repos.issues.comments.IssueComment;

import lombok.NonNull;

public interface RepositoryApi {

    /**
     * Returns the repository information through the GitHub API
     * {@code https://api.github.com/repos/loginName/repositoryName}.
     *
     * @param repositoryName The repository name
     * @return The repository information
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public List<Repository> getRepositories(@NonNull final String repositoryName);

    /**
     * Returns the repository information through the GitHub API
     * {@code https://api.github.com/repos/loginName/repositoryName}.
     *
     * @param repositoryName The repository name
     * @param queyParameter  The query parameter
     * @return The repository information
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public List<Repository> getRepositories(@NonNull final String repositoryName,
            @NonNull final QueryParameter queyParameter);

    /**
     * Returns the repository information through the GitHub API
     * {@code https://api.github.com/repos/loginName/repositoryName/issues}.
     *
     * @param repositoryName The repository name
     * @return The issue information
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public List<Issue> getIssues(@NonNull final String repositoryName);

    /**
     * Returns the repository information through the GitHub API
     * {@code https://api.github.com/repos/loginName/repositoryName/issues}.
     *
     * @param repositoryName The repository name
     * @param queyParameter  The query parameter
     * @return The issue information
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public List<Issue> getIssues(@NonNull final String repositoryName, @NonNull final QueryParameter queyParameter);

    /**
     * Returns the repository information through the GitHub API
     * {@code https://api.github.com/repos/loginName/repositoryName/issues/comments}.
     *
     * @param repositoryName The repository name
     * @return The issue comment information
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public List<IssueComment> getIssuesComments(@NonNull final String repositoryName);

    /**
     * Returns the repository information through the GitHub API
     * {@code https://api.github.com/repos/loginName/repositoryName/issues/comments}.
     *
     * @param repositoryName The repository name
     * @param queyParameter  The query parameter
     * @return The issue comment information
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public List<IssueComment> getIssuesComments(@NonNull final String repositoryName,
            @NonNull final QueryParameter queyParameter);
}
