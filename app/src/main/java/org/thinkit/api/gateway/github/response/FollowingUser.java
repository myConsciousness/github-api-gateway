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

package org.thinkit.api.gateway.github.response;

import java.io.Serializable;

import com.google.api.client.util.Key;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
public final class FollowingUser implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = -4563127151074973279L;

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
    private String gravaterId;

    /**
     * The user url
     */
    @Key
    private String url;

    /**
     * The user url (html)
     */
    @Key("html_url")
    private String htmlUrl;

    /**
     * The follower url
     */
    @Key("followers_url")
    private String followersUrl;

    /**
     * The following url
     */
    @Key("following_url")
    private String followingUrl;

    /**
     * The gist url
     */
    @Key("gists_url")
    private String gistsUrl;

    /**
     * The starred url
     */
    @Key("starred_url")
    private String starredUrl;

    /**
     * The subscription url
     */
    @Key("subscriptions_url")
    private String subscriptionsUrl;

    /**
     * The organization url
     */
    @Key("organizations_url")
    private String organizationsUrl;

    /**
     * The repository url
     */
    @Key("repos_url")
    private String reposUrl;

    /**
     * The event url
     */
    @Key("events_url")
    private String eventsUrl;

    /**
     * The received event url
     */
    @Key("received_event_url")
    private String receivedEventsUrl;

    /**
     * The user type
     */
    @Key
    private String type;

    /**
     * The site admin
     */
    @Key("site_admin")
    private boolean siteAdmin;
}
