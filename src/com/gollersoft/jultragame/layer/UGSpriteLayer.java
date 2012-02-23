package com.gollersoft.jultragame.layer;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGList;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.sprite.UGSprite;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/23/12
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSpriteLayer implements UGLayer {
    private final UG ug;
    private final UGList<UGSprite> sprites;

    public UGSpriteLayer(UG ug) {
        this.ug = ug;
        sprites = ug.createList();
    }

    @Override
    public void draw(UGGraphics g) {
        for (int i = 0; i < sprites.size(); i++)
            sprites.at(i).draw(g);
    }

    @Override
    public void frame() {

    }
}
