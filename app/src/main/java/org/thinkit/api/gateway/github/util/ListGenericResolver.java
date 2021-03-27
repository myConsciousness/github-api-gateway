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

package org.thinkit.api.gateway.github.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.google.common.reflect.TypeToken;

import io.opencensus.trace.Link;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * The class provides a method to return a {@link TypeToken} that has a specific
 * type as a generic.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ListGenericResolver<T> implements ParameterizedType {

    private Class<T> genericType;

    /**
     * The constructor.
     *
     * @param genericType The generic type
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    private ListGenericResolver(@NonNull final Class<T> genericType) {
        this.genericType = genericType;
    }

    /**
     * Returns the new instance of {@link ListGenericResolver} based on the
     * argument.
     *
     * @param <T>         The type of generic element
     * @param genericType The generic type
     * @return The new instance of {@link ListGenericResolver}
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static <T> ParameterizedType of(@NonNull final Class<T> genericType) {
        return new ListGenericResolver<>(genericType);
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[] { this.genericType };
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * It always returns the {@link Type} object represents {@link Link} .
     *
     * @deprecated It always returns the {@link Type} object represents {@link Link}
     */
    @Override
    @Deprecated
    public Type getRawType() {
        return List.class;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * It always returns the {@code null} .
     *
     * @deprecated It always returns the {@code null}
     */
    @Override
    @Deprecated
    public Type getOwnerType() {
        return null;
    }
}
