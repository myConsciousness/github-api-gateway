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

package org.thinkit.api.gateway.github.response.repos.issues.comments;

import java.io.Serializable;

import com.google.api.client.util.Key;

import org.thinkit.api.gateway.github.response.common.Creator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The entity that manages the issue comment.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
public final class IssueComment implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 7399366416181994523L;

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
     * The issue url
     */
    @Key("issue_url")
    private String issueUrl;

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
     * The comment owner
     */
    @Key("user")
    private Creator owner;

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
     * The author association
     */
    @Key("author_association")
    private String authorAssociation;

    /**
     * The body
     */
    @Key
    private String body;

    /**
     * The performed github app
     */
    @Key("performed_via_github_app")
    private String performedViaGithubApp;
}
