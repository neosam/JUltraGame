package com.gollersoft.jultragame.scene;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGList;
import com.gollersoft.jultragame.core.UGMap;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/3/12
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGActionMap implements UGMap<String, UGList<Runnable>> {
    private final UGMap<String, UGList<Runnable>> actionMap;
    private final UG ug;

    public UGActionMap(UG ug) {
        this.actionMap = ug.createMap();
        this.ug = ug;
    }


    public void put(String s, Runnable runnable) {
        if (!actionMap.hasKey(s))
            actionMap.put(s, ug.createList());
        actionMap.get(s).add(runnable);
    }

    @Override
    public void put(String s, UGList<Runnable> runnableUGList) {
        actionMap.put(s, runnableUGList);
    }

    @Override
    public UGList<Runnable> get(String s) {
        return actionMap.get(s);
    }

    @Override
    public boolean hasKey(String s) {
        return actionMap.hasKey(s);
    }

    public void executeAction(String action) {
        final UGList<Runnable> actionList = actionMap.get(action);
        if (actionList == null)
            return;
        for (int i = 0; i < actionList.size(); i++)
            actionMap.get(action).at(i).run();
    }
}
