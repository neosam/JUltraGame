package com.gollersoft.jultragame.scene;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGList;
import com.gollersoft.jultragame.layer.UGTiles;
import com.gollersoft.jultragame.sprite.UGSprite;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/3/12
 * Time: 3:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGTilesPool implements UGList<UGTiles> {
    private final UGList<UGTiles> tilesList;

    public UGTilesPool(UG ug) {
        this.tilesList = ug.createList();
    }

    @Override
    public int size() {
        return tilesList.size();
    }

    @Override
    public void add(UGTiles ugSprite) {
        tilesList.add(ugSprite);
    }

    @Override
    public UGTiles at(int i) {
        return tilesList.at(i);
    }
}
