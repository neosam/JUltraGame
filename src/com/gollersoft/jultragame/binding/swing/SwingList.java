package com.gollersoft.jultragame.binding.swing;

import com.gollersoft.jultragame.core.UGList;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/20/12
 * Time: 10:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwingList<T> implements UGList<T> {
    private final ArrayList<T> list = new ArrayList<T>();


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public T at(int i) {
        return list.get(i);
    }
}
