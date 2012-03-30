package com.gollersoft.jultragame.scene;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/22/12
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSceneAttribute {
    public final String name;
    public final String type;
    public final boolean setable;
    public final boolean getable;


    public UGSceneAttribute(String name, String type, boolean setable, boolean getable) {
        this.name = name;
        this.type = type;
        this.setable = setable;
        this.getable = getable;
    }
}
