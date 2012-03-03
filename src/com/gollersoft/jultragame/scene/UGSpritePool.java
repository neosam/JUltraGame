package com.gollersoft.jultragame.scene;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGList;
import com.gollersoft.jultragame.sprite.UGSprite;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/3/12
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSpritePool implements UGList<UGSprite> {
    private final UGList<UGSprite> sprites;

    public UGSpritePool(UG ug) {
        this.sprites = ug.createList();
    }

    @Override
    public int size() {
        return sprites.size();
    }

    @Override
    public void add(UGSprite ugSprite) {
        sprites.add(ugSprite);
    }

    @Override
    public UGSprite at(int i) {
        return sprites.at(i);
    }

    public void frame() {

    }

}
