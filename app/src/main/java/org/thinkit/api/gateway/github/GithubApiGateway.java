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

package org.thinkit.api.gateway.github;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.http.GenericUrl;

import org.thinkit.api.gateway.github.catalog.GithubApiUri;
import org.thinkit.api.gateway.github.response.UserFollower;
import org.thinkit.api.gateway.github.user.GithubUser;
import org.thinkit.api.gateway.github.util.CommunicationResolver;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "from")
public final class GithubApiGateway implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = -585767869852520568L;

    /**
     * The GitHub User
     */
    @NonNull
    private GithubUser githubUser;

    public List<UserFollower> getFollowers() {

        final GenericUrl genericUrl = new GenericUrl(
                String.format(GithubApiUri.FOLLOWERS.getTag(), githubUser.getUserName()));

        return Arrays.asList(CommunicationResolver.get(genericUrl, UserFollower[].class));
    }
}
