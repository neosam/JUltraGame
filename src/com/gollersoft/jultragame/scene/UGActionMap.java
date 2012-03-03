package com.gollersoft.jultragame.scene;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGMap;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/3/12
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGActionMap implements UGMap<String, Runnable> {
    private final UGMap<String, Runnable> actionMap;

    public UGActionMap(UG ug) {
        this.actionMap = ug.createMap();
    }

    @Override
    public void put(String s, Runnable runnable) {
        actionMap.put(s, runnable);
    }

    @Override
    public Runnable get(String s) {
        return actionMap.get(s);
    }

    public void executeAction(String action) {
        actionMap.get(action).run();
    }
}
