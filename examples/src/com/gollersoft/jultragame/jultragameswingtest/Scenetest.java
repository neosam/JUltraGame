package com.gollersoft.jultragame.jultragameswingtest;

import com.gollersoft.jultragame.binding.swing.UGSwing;
import com.gollersoft.jultragame.core.UGFinalRect;
import com.gollersoft.jultragame.core.display.UGCamera;
import com.gollersoft.jultragame.core.display.UGImage;
import com.gollersoft.jultragame.layer.UGSpriteLayer;
import com.gollersoft.jultragame.scene.UGGravityAddon;
import com.gollersoft.jultragame.scene.UGScene;
import com.gollersoft.jultragame.scene.UGSceneAddon;
import com.gollersoft.jultragame.sprite.UGSprite;
import com.gollersoft.jultragame.sprite.UGSpriteAnimation;
import com.gollersoft.jultragame.sprite.UGSpriteAnimationStorage;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 3/17/12
 * Time: 9:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Scenetest {
    public static void main(String[] args) {
        final UGSwing ug = new UGSwing(320, 240);
        final UGScene scene = new UGScene(ug);
        final UGImage image = ug.getImage("testimg.png");
        final UGCamera camera = new UGCamera();
        final UGSpriteAnimation animation = new UGSpriteAnimation(new UGFinalRect(0, 0, 32, 32), 0, 2);
        final UGSpriteAnimationStorage animationStorage = new UGSpriteAnimationStorage(ug);
        animationStorage.put("default", animation);
        final UGSprite sprite = new UGSprite(image, animationStorage);
        UGSpriteLayer spriteLayer = new UGSpriteLayer(ug, camera);
        spriteLayer.add(sprite);
        scene.addLayer(spriteLayer);
        scene.registerSprite(sprite);
        scene.getSpritePool().getSpritePoolItem(sprite).getLabels().add("gravity");
        UGSceneAddon gravityAddon = new UGGravityAddon(ug);
        gravityAddon.register(scene);


        JFrame frame = new JFrame("UG Scenetest");
        frame.add((JPanel) ug.display.getElement());
        frame.pack();
        frame.setVisible(true);
    }
}
