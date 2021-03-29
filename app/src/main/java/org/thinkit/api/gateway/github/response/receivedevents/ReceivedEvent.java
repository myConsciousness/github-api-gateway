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

package org.thinkit.api.gateway.github.response.receivedevents;

import java.io.Serializable;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The entity that manages the received event.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@Getter
public final class ReceivedEvent extends GenericData implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 858133184525397902L;

    /**
     * The id
     */
    @Key
    private String id;

    /**
     * The type
     */
    @Key
    private String type;

    /**
     * The actor
     */
    @Key
    private EventActor actor;

    /**
     * The repository
     */
    @Key("repo")
    private EventRepository repository;

    /**
     * The payload
     */
    @Key
    private EventPayload payload;

    /**
     * The flag whether the event has been published
     */
    @Key("public")
    private boolean publicEvent;

    /**
     * The created datetime
     */
    @Key("created_at")
    private String createdAt;
}