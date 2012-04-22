package com.gollersoft.jultragame.layer;

import com.gollersoft.jultragame.collision.Collision;
import com.gollersoft.jultragame.core.*;
import com.gollersoft.jultragame.core.display.UGCamera;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.sprite.UGSprite;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/23/12
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSpriteLayer implements UGLayer, UGList<UGSprite> {
    private final UG ug;
    private final UGList<UGSprite> sprites;
    private final UGCamera camera;

    public UGSpriteLayer(UG ug, UGCamera camera) {
        this.ug = ug;
        sprites = ug.createList();
        this.camera = camera;
    }

    @Override
    public void draw(UGGraphics g) {
        for (int i = 0; i < sprites.size(); i++)
            sprites.at(i).draw(g, camera);
    }

    @Override
    public void frame() {
        for (int i = 0; i < sprites.size(); i++)
            sprites.at(i).step();
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

    @Override
    public void remove(UGSprite ugSprite) {
        sprites.remove(ugSprite);
    }

    public UGSprite atPixelPosition(int x, int y) {
        for (int i = 0; i < size(); i++) {
            final UGSprite sprite = sprites.at(i);
            final UGFinalRect rect = sprite.getSpriteRect();
            System.out.println(rect);
            if (Collision.pointInRect(new UGFinalPoint(x, y), rect))
                return sprite;
        }
        return null;
    }
}
