package com.gollersoft.jultragame.scene;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGList;
import com.gollersoft.jultragame.sprite.UGSprite;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/17/12
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSpritePoolItem {
    private final UGSprite sprite;
    private final UGList<String> labels;

    public UGSpritePoolItem(UG ug, UGSprite sprite) {
        this.sprite = sprite;
        this.labels = ug.createList();
    }

    public UGSprite getSprite() {
        return sprite;
    }

    public UGList<String> getLabels() {
        return labels;
    }
}
