package com.gollersoft.jultragame.scene;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.display.UGCamera;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.layer.UGLayer;
import com.gollersoft.jultragame.layer.UGLayerList;
import com.gollersoft.jultragame.layer.UGTile;
import com.gollersoft.jultragame.layer.UGTiles;
import com.gollersoft.jultragame.sprite.UGSprite;

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
    private final UGLayerList layerList;


    public UGScene(UG ug) {
        this.ug = ug;
        actionMap = new UGActionMap(ug);
        spritePool = new UGSpritePool(ug);
        tilesPool = new UGTilesPool(ug);
        camera = new UGCamera();
        layerList = new UGLayerList(ug);
    }

    public void registerSprite(UGSprite sprite) {
        spritePool.add(sprite);
    }

    public void registerTiles(UGTiles tiles) {
        tilesPool.add(tiles);
    }

    public void registerAction(String actionName, Runnable action) {
        actionMap.put(actionName, action);
    }

    public void addLayer(UGLayer layer) {
        layerList.add(layer);
    }

    public UGActionMap getActionMap() {
        return actionMap;
    }

    public UGSpritePool getSpritePool() {
        return spritePool;
    }

    public UGTilesPool getTilesPool() {
        return tilesPool;
    }

    public UGCamera getCamera() {
        return camera;
    }

    public UGLayerList getLayerList() {
        return layerList;
    }

    public void draw(UGGraphics g) {
        layerList.draw(g);
    }

    public void frame() {

    }
}
