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

package org.thinkit.api.gateway.github.response.issues;

import java.io.Serializable;
import java.util.List;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

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

    private String url;

    private String repositoryUrl;

    private String labelsUrl;

    private String commentsUrl;

    private String eventsUrl;

    private String htmlUrl;

    private int id;

    private String nodeId;

    private int number;

    private String title;

    @Key("user")
    private Issuer issuer;

    private List<IssueLabel> labels;

    private String state;

    private boolean locked;

    private IssueAssignee assignee;

    private List<IssueAssignee> assignees;

    private IssueMilestone milestone;

    private int comments;

    private String createdAt;

    private String updatedAt;

    private String closedAt;

    private String auhtorAssociation;

    private String activeLockReason;

    private String body;

    private IssueClosedUser closedBy;
}
