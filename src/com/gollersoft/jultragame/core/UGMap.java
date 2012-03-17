package com.gollersoft.jultragame.core;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 8:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UGMap<T, O> {
    void put(T t, O o);
    O get(T t);
    boolean hasKey(T t);
}
