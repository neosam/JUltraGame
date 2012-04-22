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
    private final UGList<UGSpritePoolItem> sprites;
    private final UG ug;

    public UGSpritePool(UG ug) {
        this.sprites = ug.createList();
        this.ug = ug;
    }

    @Override
    public int size() {
        return sprites.size();
    }

    @Override
    public void add(UGSprite ugSprite) {
        sprites.add(new UGSpritePoolItem(ug, ugSprite));
    }

    @Override
    public UGSprite at(int i) {
        return sprites.at(i).getSprite();
    }

    @Override
    public void remove(UGSprite ugSprite) {
        sprites.remove(getSpritePoolItem(ugSprite));
    }

    public UGSpritePoolItem getSpritePoolItemAt(int i) {
        return sprites.at(i);
    }

    public UGSpritePoolItem getSpritePoolItem(UGSprite sprite) {
        for (int i = 0; i < sprites.size(); i++) {
            if (sprites.at(i).getSprite() == sprite)
                return sprites.at(i);
        }
        return null;
    }

    public UGList<UGSpritePoolItem> getSpritePoolItemsWithLabel(String label) {
        final UGList<UGSpritePoolItem> spriteList = ug.createList();
        for (int i = 0; i < sprites.size(); i++) {
            final UGSpritePoolItem item = sprites.at(i);
            for (int j = 0; j < item.getLabels().size(); j++) {
                if (item.getLabels().at(j).equals(label)) {
                    spriteList.add(item);
                    break;
                }
            }
        }
        return spriteList;
    }

    public void frame() {

    }

}
