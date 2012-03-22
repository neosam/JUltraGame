package com.gollersoft.jultragame.scene;

import com.gollersoft.jultragame.core.UGList;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/22/12
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
abstract public class UGSceneAddon {
    abstract public void register(UGScene scene);
    abstract public UGList getAttributes();
    abstract public void setAttribute(String attribute, Object value);

}
