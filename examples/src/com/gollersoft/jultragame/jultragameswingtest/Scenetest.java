package com.gollersoft.jultragame.jultragameswingtest;

import com.gollersoft.jultragame.binding.swing.UGSwing;
import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.display.UGCamera;
import com.gollersoft.jultragame.core.display.UGImage;
import com.gollersoft.jultragame.layer.UGImageScrollLayer;
import com.gollersoft.jultragame.layer.UGLayer;
import com.gollersoft.jultragame.layer.UGSpriteLayer;
import com.gollersoft.jultragame.scene.UGScene;

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
        UGImage image = ug.getImage("testimg.png");
        UGLayer myLayer = new UGImageScrollLayer(image, scene.getCamera());
        scene.addLayer(myLayer);
        scene.registerPerFrameAction(new Runnable() {
            @Override
            public void run() {
                scene.getCamera().y--;
            }
        });


        JFrame frame = new JFrame("UG Scenetest");
        frame.add((JPanel) ug.display.getElement());
        frame.pack();
        frame.setVisible(true);
    }
}
