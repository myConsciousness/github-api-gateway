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

package org.thinkit.api.gateway.github.response.repos;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The entity that manages the repository information.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
@Getter
public final class Repository implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 545376925054158470L;

    private int id;

    private String nodeId;

    private String name;

    private String fullName;

    private boolean privateRepository;

    private RepositoryOwner owner;

    private String htmlUrl;

    private String description;

    private boolean fork;

    private String url;

    private String forksUrl;

    private String keysUrl;

    private String collaboratorsUrl;

    private String teamsUrl;

    private String hooksUrl;

    private String issueEventsUrl;

    private String eventsUrl;

    private String assigneesUrl;

    private String branchesUrl;

    private String tagsUrl;

    private String blogsUrl;

    private String gitTagsUrl;

    private String gitRefssUrl;

    private String treesUrl;

    private String statusesUrl;

    private String languagesUrl;

    private String stargazersUrl;

    private String contributorsUrl;

    private String subscribersUrl;

    private String subscriptionUrl;

    private String commitsUrl;

    private String gitCommitsUrl;

    private String commentsUrl;

    private String issueCommentUrl;

    private String contentsUrl;

    private String compareUrl;

    private String mergesUrl;

    private String archiveUrl;

    private String downloadsUrl;

    private String issuesUrl;

    private String pullsUrl;

    private String milestonesUrl;

    private String notificationsUrl;

    private String labelsUrl;

    private String releasesUrl;

    private String deploymentsUrl;

    private String createdAt;

    private String updatedAt;

    private String pushedAt;

    private String gitUrl;

    private String sshUrl;

    private String cloneUrl;

    private String svnUrl;

    private String homepage;

    private int size;

    private int stargazersCount;

    private int watchersCount;

    private String language;

    private boolean issues;

    private boolean projects;

    private boolean downloads;

    private boolean wiki;

    private boolean pages;

    private int forksCount;

    private String mirrorUrl;

    private boolean archived;

    private boolean disabled;

    private int openIssuesCount;

    private RepositoryLicense license;

    private int forks;

    private int openIssues;

    private int watchers;

    private String defaultBranch;
}
