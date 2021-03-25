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

    @Key("stargazers_url")
    private String stargazersUrl;

    @Key("contributors_url")
    private String contributorsUrl;

    @Key("subscribers_url")
    private String subscribersUrl;

    @Key("subscription_url")
    private String subscriptionUrl;

    @Key("commits_url")
    private String commitsUrl;

    @Key("git_commits_url")
    private String gitCommitsUrl;

    @Key("comments_url")
    private String commentsUrl;

    @Key("issue_comment_url")
    private String issueCommentUrl;

    @Key("contents_url")
    private String contentsUrl;

    @Key("compare_url")
    private String compareUrl;

    @Key("merges_url")
    private String mergesUrl;

    @Key("archive_url")
    private String archiveUrl;

    @Key("downloads_url")
    private String downloadsUrl;

    @Key("issues_url")
    private String issuesUrl;

    @Key("pulls_url")
    private String pullsUrl;

    @Key("milestones_url")
    private String milestonesUrl;

    @Key("notifications_url")
    private String notificationsUrl;

    @Key("labels_url")
    private String labelsUrl;

    @Key("releases_url")
    private String releasesUrl;

    @Key("deployments_url")
    private String deploymentsUrl;

    @Key("created_at")
    private String createdAt;

    @Key("updated_at")
    private String updatedAt;

    @Key("pushed_at")
    private String pushedAt;

    @Key("git_url")
    private String gitUrl;

    @Key("ssh_url")
    private String sshUrl;

    @Key("clone_url")
    private String cloneUrl;

    @Key("svn_url")
    private String svnUrl;

    @Key
    private String homepage;

    @Key
    private int size;

    @Key("stargazers_count")
    private int stargazersCount;

    @Key("watchers_count")
    private int watchersCount;

    @Key("language")
    private String language;

    @Key("has_issues")
    private boolean issues;

    @Key("has_projects")
    private boolean projects;

    @Key("has_downloads")
    private boolean downloads;

    @Key("has_wiki")
    private boolean wiki;

    @Key("has_pages")
    private boolean pages;

    @Key("forks_count")
    private int forksCount;

    @Key("mirror_url")
    private String mirrorUrl;

    @Key
    private boolean archived;

    @Key
    private boolean disabled;

    @Key("open_issues_count")
    private int openIssuesCount;

    @Key
    private RepositoryLicense license;

    @Key
    private int forks;

    @Key("open_issues")
    private int openIssues;

    @Key
    private int watchers;

    @Key("default_branch")
    private String defaultBranch;
}
