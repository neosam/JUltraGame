package com.gollersoft.jultragame.scene;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.display.UGCamera;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/3/12
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGScene {
    private final UG ug;
    private final UGActionMap actionMap;
    private final UGSpritePool spritePool;
    private final UGTilesPool tilesPool;
    private final UGCamera camera;


    public UGScene(UG ug) {
        this.ug = ug;
        actionMap = new UGActionMap(ug);
        spritePool = new UGSpritePool(ug);
        tilesPool = new UGTilesPool(ug);
        camera = new UGCamera();
    }


}
