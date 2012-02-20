package com.gollersoft.jultragame.core;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/20/12
 * Time: 10:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UGList<T> {
    public int size();
    public void add(T t);
    public T at(int i);
}
