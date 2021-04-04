package org.thinkit.api.gateway.github.communication;

import java.util.List;

import com.google.api.client.http.GenericUrl;

import lombok.NonNull;

public interface Communicator {

    /**
     * Sends a Get request to the request URL.
     *
     * <p>
     * The response will be parsed into the response type specified as the second
     * argument and returned.
     *
     * @param <T>           The response type
     * @param genericUrl    The request url object
     * @param responseClass The response class
     * @return The JSON response
     *
     * @exception NullPointerException if {@code null} is passed as an argument
     */
    public <T> T get(@NonNull final GenericUrl genericUrl, @NonNull final Class<T> responseClass);

    /**
     * Sends a Get request to the request URL.
     *
     * <p>
     * The response will be parsed into the list of response type specified as the
     * second argument and returned.
     *
     * @param <T>           The response type
     * @param genericUrl    The request url object
     * @param responseClass The response class
     * @return The JSON responses as list
     *
     * @exception NullPointerException if {@code null} is passed as an argument
     */
    public <T> List<T> getAsList(@NonNull final GenericUrl genericUrl, @NonNull final Class<T> responseClass);
}
