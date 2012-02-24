package com.gollersoft.jultragame.jultragameswingtest;

import com.gollersoft.jultragame.binding.swing.UGSwing;
import com.gollersoft.jultragame.core.*;
import com.gollersoft.jultragame.core.display.*;
import com.gollersoft.jultragame.core.event.UGKeyEvent;
import com.gollersoft.jultragame.core.event.UGKeyboardDelegate;
import com.gollersoft.jultragame.core.event.UGMouseClickEvent;
import com.gollersoft.jultragame.core.event.UGMouseDelegate;
import com.gollersoft.jultragame.layer.*;
import com.gollersoft.jultragame.sprite.UGSprite;
import com.gollersoft.jultragame.sprite.UGSpriteAnimation;
import com.gollersoft.jultragame.sprite.UGSpriteAnimationStorage;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 7:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Testmain {
    public static void main(String[] args) {
        final UG ug = new UGSwing(320, 240);
        final JFrame frame = new JFrame("JUltraGame Test");
        final JPanel panel = (JPanel) ug.display.getElement();
        final Point position = new Point();
        final Point speed = new Point();
        final UGImage img = ug.getImage("testimg.png");
        final UGSpriteAnimation animation = new UGSpriteAnimation(new UGFinalRect(0, 0, 32, 32), 0, 2);
        final UGSpriteAnimationStorage animationStorage = new UGSpriteAnimationStorage(ug);
        animationStorage.put("default", animation);
        final UGSprite sprite = new UGSprite(img, animationStorage);
        final UGLayerList layers = new UGLayerList(ug);
        final UGCamera camera = new UGCamera();
        final UGLayer imageLayer = new UGImageScrollLayer(img, camera);
        layers.add(imageLayer);
        final UGTiles tiles = new UGTiles(new UGFinalDimension(30, 30), img,
                new UGFinalDimension(32, 32));
        final UGTileLayer tileLayer = new UGTileLayer(tiles, camera);
        tiles.setTileAt(new UGTile(1, 0), 1, 0);
        tiles.setTileAt(new UGTile(0, 1), 0, 1);
        tiles.setTileAt(new UGTile(1, 1), 1, 1);

        frame.setLayout(new BorderLayout());
        ug.display.setRenderDelegate(new UGRenderDelegate() {
            final UGColor black = new UGColor(0, 0, 0);
            final UGColor red = new UGColor(255, 0, 0);
            final UGColor white = new UGColor(255, 255, 255);
            int width
                    ,
                    height;

            @Override
            public void draw(UGGraphics g) {
                g.fillRect(0, 0, width, height, white);
                sprite.draw(g);
                g.drawImage(img, width - 32, height - 32, 32, 32, 32, 32);
                g.drawRect(60, 60, 100, 100, red);
                layers.draw(g);
                tileLayer.draw(g);
            }

            @Override
            public void resize(int width, int height) {
                this.width = width;
                this.height = height;
            }
        });
        ug.setKeyboardDelgate(new UGKeyboardDelegate() {
            @Override
            public void keydown(UGKeyEvent event) {
                switch (ug.keycodeTranslation.translateKeyCode(event.keycode)) {
                    case up:
                        speed.y = -4;
                        break;
                    case down:
                        speed.y = 4;
                        break;
                    case left:
                        speed.x = -4;
                        break;
                    case right:
                        speed.x = 4;
                        break;
                }
            }

            @Override
            public void keyup(UGKeyEvent event) {
                switch (ug.keycodeTranslation.translateKeyCode(event.keycode)) {
                    case up:
                        speed.y = 0;
                        break;
                    case down:
                        speed.y = 0;
                        break;
                    case left:
                        speed.x = 0;
                        break;
                    case right:
                        speed.x = 0;
                        break;
                }
            }
        });
        ug.setMouseDelegate(new UGMouseDelegate() {
            @Override
            public void mouseClicked(UGMouseClickEvent event) {
                System.out.println(event);
            }
        });
        ug.stuffDelegate = new UGStuffDelegate() {
            @Override
            public void frame() {
                position.x += speed.x;
                position.y += speed.y;

                sprite.step();
                sprite.setPos(new UGPoint(position.x, position.y));
                camera.x = position.x;
                camera.y = position.y;

                tileLayer.frame();
            }
        };

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.requestFocus();
    }
}
