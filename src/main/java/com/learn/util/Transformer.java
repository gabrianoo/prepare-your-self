package com.learn.util;

/**
 * This is the contract for transforming any business object to entity object and the opposite.
 * @param <S> The source data type
 * @param <T> The target data type
 */
public interface Transformer<S, T> {

    /**
     * Convert the source data type to the target data type.
     * @param s The source data type
     * @return The target data type
     */
    T fromSource(S s);

    /**
     * Convert the target data type to the source data type.
     * @param t The target data type
     * @return The source data type
     */
    S fromTarget(T t);
}
