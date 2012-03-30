package com.gollersoft.jultragame.scene;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGList;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/22/12
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGGravityAddon extends UGSceneAddon {
    private double acceleration = 2.0;
    private final UG ug;

    public UGGravityAddon(UG ug) {
        this.ug = ug;
    }


    @Override
    public void register(final UGScene scene) {
        scene.registerPerFrameAction(new Runnable() {
            @Override
            public void run() {
                UGList<UGSpritePoolItem> spriteItemList = scene.getSpritePool().getSpritePoolItemsWithLabel("gravity");
                for (int i = 0; i < spriteItemList.size(); i++)
                    spriteItemList.at(i).getSprite().getPos().y += 1;
            }
        });
    }

    @Override
    public UGList getAttributes() {
        final UGList<UGSceneAttribute> res = ug.createList();
        res.add(new UGSceneAttribute("acceleration", "double", true, true));
        return res;
    }

    @Override
    public void setAttribute(String attribute, Object value) {
        if (attribute.equals("acceleration"))
            acceleration = (Double) value;
    }
}
