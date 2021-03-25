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

    /**
     * The repository id
     */
    @Key
    private int id;

    /**
     * The node id
     */
    @Key("node_id")
    private String nodeId;

    /**
     * The repository name
     */
    @Key
    private String name;

    /**
     * The repository full name
     */
    @Key("full_name")
    private String fullName;

    /**
     * The private repository
     */
    @Key("private")
    private boolean privateRepository;

    /**
     * The owner
     */
    @Key
    private RepositoryOwner owner;

    /**
     * The html url
     */
    @Key("html_url")
    private String htmlUrl;

    /**
     * The description
     */
    @Key
    private String description;

    /**
     * The fork
     */
    @Key
    private boolean fork;

    /**
     * The url
     */
    @Key
    private String url;

    /**
     * The forks url
     */
    @Key("forks_url")
    private String forksUrl;

    /**
     * The keys url
     */
    @Key("keys_url")
    private String keysUrl;

    /**
     * The collaborators url
     */
    @Key("collaborators_url")
    private String collaboratorsUrl;

    /**
     * The teams url
     */
    @Key("teams_url")
    private String teamsUrl;

    /**
     * The hooks url
     */
    @Key("hooks_url")
    private String hooksUrl;

    /**
     * The issue events url
     */
    @Key("issue_events_url")
    private String issueEventsUrl;

    /**
     * The events url
     */
    @Key("events_url")
    private String eventsUrl;

    /**
     * The assignees url
     */
    @Key("assignees_url")
    private String assigneesUrl;

    /**
     * The branches url
     */
    @Key("branches_url")
    private String branchesUrl;

    /**
     * The tags url
     */
    @Key("tags_url")
    private String tagsUrl;

    /**
     * The blogs url
     */
    @Key("blogs_url")
    private String blogsUrl;

    /**
     * The git tags url
     */
    @Key("git_tags_url")
    private String gitTagsUrl;

    /**
     * The git refs url
     */
    @Key("git_refs_url")
    private String gitRefsUrl;

    /**
     * The trees url
     */
    @Key("trees_url")
    private String treesUrl;

    /**
     * The statues url
     */
    @Key("statues_url")
    private String statusesUrl;

    /**
     * The languages url
     */
    @Key("languages_url")
    private String languagesUrl;

    /**
     * The stargazers url
     */
    @Key("stargazers_url")
    private String stargazersUrl;

    /**
     * The contributors url
     */
    @Key("contributors_url")
    private String contributorsUrl;

    /**
     * The subscribers url
     */
    @Key("subscribers_url")
    private String subscribersUrl;

    /**
     * The subscription url
     */
    @Key("subscription_url")
    private String subscriptionUrl;

    /**
     * The commits url
     */
    @Key("commits_url")
    private String commitsUrl;

    /**
     * The git commits url
     */
    @Key("git_commits_url")
    private String gitCommitsUrl;

    /**
     * The comments url
     */
    @Key("comments_url")
    private String commentsUrl;

    /**
     * The issue comment url
     */
    @Key("issue_comment_url")
    private String issueCommentUrl;

    /**
     * The contents url
     */
    @Key("contents_url")
    private String contentsUrl;

    /**
     * The compare url
     */
    @Key("compare_url")
    private String compareUrl;

    /**
     * The merges url
     */
    @Key("merges_url")
    private String mergesUrl;

    /**
     * The archive url
     */
    @Key("archive_url")
    private String archiveUrl;

    /**
     * The downloads url
     */
    @Key("downloads_url")
    private String downloadsUrl;

    /**
     * The issues url
     */
    @Key("issues_url")
    private String issuesUrl;

    /**
     * The pulls url
     */
    @Key("pulls_url")
    private String pullsUrl;

    /**
     * The milestones url
     */
    @Key("milestones_url")
    private String milestonesUrl;

    /**
     * The notifications url
     */
    @Key("notifications_url")
    private String notificationsUrl;

    /**
     * The labels url
     */
    @Key("labels_url")
    private String labelsUrl;

    /**
     * The releases url
     */
    @Key("releases_url")
    private String releasesUrl;

    /**
     * The deployment url
     */
    @Key("deployments_url")
    private String deploymentsUrl;

    /**
     * The created datetime
     */
    @Key("created_at")
    private String createdAt;

    /**
     * The updated datetime
     */
    @Key("updated_at")
    private String updatedAt;

    /**
     * The pushed datetime
     */
    @Key("pushed_at")
    private String pushedAt;

    /**
     * The git url
     */
    @Key("git_url")
    private String gitUrl;

    /**
     * The ssh url
     */
    @Key("ssh_url")
    private String sshUrl;

    /**
     * The clone url
     */
    @Key("clone_url")
    private String cloneUrl;

    /**
     * The svn url
     */
    @Key("svn_url")
    private String svnUrl;

    /**
     * The home page
     */
    @Key
    private String homepage;

    /**
     * The size
     */
    @Key
    private int size;

    /**
     * The stargazers count
     */
    @Key("stargazers_count")
    private int stargazersCount;

    /**
     * The watchers count
     */
    @Key("watchers_count")
    private int watchersCount;

    /**
     * The language
     */
    @Key("language")
    private String language;

    /**
     * The flag of issues existence
     */
    @Key("has_issues")
    private boolean issuesCreated;

    /**
     * The flag of projects existence
     */
    @Key("has_projects")
    private boolean projectsCreated;

    /**
     * The flag of downloads existence
     */
    @Key("has_downloads")
    private boolean downloadsCreated;

    /**
     * The flag of wiki existence
     */
    @Key("has_wiki")
    private boolean wikiCreated;

    /**
     * The flag of pages existence
     */
    @Key("has_pages")
    private boolean pagesCreated;

    /**
     * The forks count
     */
    @Key("forks_count")
    private int forksCount;

    /**
     * The mirror count
     */
    @Key("mirror_url")
    private String mirrorUrl;

    /**
     * The archived
     */
    @Key
    private boolean archived;

    /**
     * The disabled
     */
    @Key
    private boolean disabled;

    /**
     * The open issues count
     */
    @Key("open_issues_count")
    private int openIssuesCount;

    /**
     * The license
     */
    @Key
    private RepositoryLicense license;

    /**
     * The forks
     */
    @Key
    private int forks;

    /**
     * The open issues
     */
    @Key("open_issues")
    private int openIssues;

    /**
     * The watchers
     */
    @Key
    private int watchers;

    /**
     * The default branch
     */
    @Key("default_branch")
    private String defaultBranch;
}
