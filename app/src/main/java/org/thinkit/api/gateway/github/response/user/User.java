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

package org.thinkit.api.gateway.github.response.user;

import java.io.Serializable;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The entity that manages the user information.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
public final class User extends GenericData implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 987094486199214324L;

    /**
     * The login name
     */
    @Key
    private String login;

    /**
     * The user id
     */
    @Key
    private int id;

    /**
     * The node id
     */
    @Key("node_id")
    private String nodeId;

    /**
     * The avater url
     */
    @Key("avater_url")
    private String avaterUrl;

    /**
     * The gravater id
     */
    @Key("gravater_id")
    private String gravatarId;

    /**
     * The url
     */
    @Key("url")
    private String url;

    /**
     * The html url
     */
    @Key("html_url")
    private String hrmlUrl;

    /**
     * The followers url
     */
    @Key("followers_url")
    private String followersUrl;

    /**
     * The following url
     */
    @Key("following_url")
    private String followingUrl;

    /**
     * The gists url
     */
    @Key("gists_url")
    private String gistsUrl;

    /**
     * The starred url
     */
    @Key("starred_url")
    private String starredUrl;

    /**
     * The sbscriptions url
     */
    @Key("subscriptions_url")
    private String subscriptionsUrl;

    /**
     * The organizations url
     */
    @Key("organizations_url")
    private String organizationsUrl;

    /**
     * The repos url
     */
    @Key("repos_url")
    private String reposUrl;

    /**
     * The events url
     */
    @Key("events_url")
    private String eventsUrl;

    /**
     * The received events url
     */
    @Key("received_events_url")
    private String receivedEventsUrl;

    /**
     * The type
     */
    @Key
    private String type;

    /**
     * The site admin
     */
    @Key("site_admin")
    private boolean siteAdmin;

    /**
     * The user name
     */
    @Key
    private String name;

    /**
     * The company
     */
    @Key
    private String company;

    /**
     * The blog
     */
    @Key
    private String blog;

    /**
     * The location
     */
    @Key
    private String location;

    /**
     * The email
     */
    @Key
    private String email;

    /**
     * The hireable
     */
    @Key
    private boolean hireable;

    /**
     * The bio
     */
    @Key
    private String bio;

    /**
     * The twitter user name
     */
    @Key("twitter_username")
    private String twitterUsername;

    /**
     * The count of public repos
     */
    @Key("public_repos")
    private int publicRepos;

    /**
     * The count of public gists
     */
    @Key("public_gists")
    private int publicGists;

    /**
     * The count of followers
     */
    @Key
    private int followers;

    /**
     * The count of following
     */
    @Key
    private int following;

    /**
     * The created datetime
     */
    @Key("created_at")
    private String createdAt;

    /**
     * The updated datetime
     */
    @Key("updatedAt")
    private String updatedAt;
}
