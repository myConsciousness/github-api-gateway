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

package org.thinkit.api.gateway.github.response.repos.issues;

import java.io.Serializable;
import java.util.List;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

import org.thinkit.api.gateway.github.response.common.Creator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The entity that manages the issue.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
public final class Issue extends GenericJson implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = -4777671516268321438L;

    /**
     * The url
     */
    @Key
    private String url;

    /**
     * The repository url
     */
    @Key
    private String repositoryUrl;

    /**
     * The labels url
     */
    @Key("labels_url")
    private String labelsUrl;

    /**
     * The comments url
     */
    @Key("comments_url")
    private String commentsUrl;

    /**
     * The events url
     */
    @Key("events_url")
    private String eventsUrl;

    /**
     * The html url
     */
    @Key("html_url")
    private String htmlUrl;

    /**
     * The id
     */
    @Key
    private int id;

    /**
     * The node id
     */
    @Key("node_id")
    private String nodeId;

    /**
     * The number
     */
    @Key
    private int number;

    /**
     * The title
     */
    @Key
    private String title;

    /**
     * The issuer
     */
    @Key("user")
    private Creator issuer;

    /**
     * The labels
     */
    @Key
    private List<IssueLabel> labels;

    /**
     * The state
     */
    @Key
    private String state;

    /**
     * The locked
     */
    @Key
    private boolean locked;

    /**
     * The assignee
     */
    @Key
    private Creator assignee;

    /**
     * The assignees
     */
    @Key
    private List<Creator> assignees;

    /**
     * The milestone
     */
    @Key
    private IssueMilestone milestone;

    /**
     * The comments
     */
    @Key
    private int comments;

    /**
     * The created datetime
     */
    @Key("created_at")
    private String createdAt;

    /**
     * The update datetime
     */
    @Key("updated_at")
    private String updatedAt;

    /**
     * The closed datetime
     */
    @Key("closed_at")
    private String closedAt;

    /**
     * The author association
     */
    @Key("author_association")
    private String auhtorAssociation;

    /**
     * The active lock reason
     */
    @Key("active_lock_reason")
    private String activeLockReason;

    /**
     * The body
     */
    @Key
    private String body;

    /**
     * The closed user
     */
    @Key("closed_by")
    private Creator closedBy;
}
