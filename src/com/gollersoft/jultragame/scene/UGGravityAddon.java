package com.gollersoft.jultragame.scene;

import com.gollersoft.jultragame.core.UGList;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/22/12
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGGravityAddon extends UGSceneAddon {
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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAttribute(String attribute, Object value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
