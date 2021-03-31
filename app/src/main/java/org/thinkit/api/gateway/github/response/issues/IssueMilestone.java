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

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The entity that manages the issue milestone.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
public final class IssueMilestone extends GenericJson implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 9035171013127197334L;

    /**
     * The url
     */
    @Key
    private String url;

    /**
     * The html url
     */
    @Key("html_url")
    private String htmlUrl;

    /**
     * The labels url
     */
    @Key("labels_url")
    private String labelsUrl;

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
     * The description
     */
    @Key
    private String description;

    /**
     * The creator
     */
    @Key
    private MilestoneCreator creator;

    /**
     * The open issues
     */
    @Key("open_issues")
    private int openIssues;

    /**
     * The closed issues
     */
    @Key("closed_issues")
    private int closedIssues;

    /**
     * The state
     */
    @Key
    private String state;

    /**
     * The closed datetime
     */
    @Key("created_at")
    private String createdAt;

    /**
     * The updated datetime
     */
    @Key("updated_at")
    private String updatedAt;

    /**
     * The due datetime
     */
    @Key("due_on")
    private String dueOn;

    /**
     * The closed datetime
     */
    @Key("closed_at")
    private String closedAt;
}
