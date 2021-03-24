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
 * The entity that manages the license information of the repository.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
@Getter
public final class RepositoryLicense implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 2433936177852665041L;

    /**
     * The key
     */
    @Key
    private String key;

    /**
     * The name
     */
    @Key
    private String name;

    /**
     * The spdx (software package data exchange) id
     */
    @Key("spdx_id")
    private String spdxId;

    /**
     * The url
     */
    @Key
    private String url;

    /**
     * The node id
     */
    @Key("node_id")
    private String nodeId;
}
