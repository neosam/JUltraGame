package com.gollersoft.jultragame.binding.swing;

import com.gollersoft.jultragame.core.UGMap;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 8:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwingMap<T, O> implements UGMap<T, O> {
    private final HashMap<T, O> aMap = new HashMap<T, O>();

    @Override
    public void put(T t, O o) {
        aMap.put(t, o);
    }

    @Override
    public O get(T o) {
        return aMap.get(o);
    }

    @Override
    public boolean hasKey(T t) {
        return aMap.containsKey(t);
    }

}
