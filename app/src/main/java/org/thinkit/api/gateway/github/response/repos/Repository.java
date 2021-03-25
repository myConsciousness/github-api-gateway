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

import com.google.api.client.util.Key;

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

    @Key
    private int id;

    @Key("node_id")
    private String nodeId;

    @Key
    private String name;

    @Key("full_name")
    private String fullName;

    @Key("private")
    private boolean privateRepository;

    @Key
    private RepositoryOwner owner;

    @Key("html_url")
    private String htmlUrl;

    @Key
    private String description;

    @Key
    private boolean fork;

    @Key
    private String url;

    @Key("forks_url")
    private String forksUrl;

    @Key("keys_url")
    private String keysUrl;

    @Key("collaborators_url")
    private String collaboratorsUrl;

    @Key("teams_url")
    private String teamsUrl;

    @Key("hooks_url")
    private String hooksUrl;

    @Key("issue_events_url")
    private String issueEventsUrl;

    @Key("events_url")
    private String eventsUrl;

    @Key("assignees_url")
    private String assigneesUrl;

    @Key("branches_url")
    private String branchesUrl;

    @Key("tags_url")
    private String tagsUrl;

    @Key("blogs_url")
    private String blogsUrl;

    @Key("git_tags_url")
    private String gitTagsUrl;

    @Key("git_refs_url")
    private String gitRefsUrl;

    @Key("trees_url")
    private String treesUrl;

    @Key("statues_url")
    private String statusesUrl;

    @Key("languages_url")
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
