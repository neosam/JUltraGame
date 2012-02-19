package com.gollersoft.jultragameswingtest;

import com.gollersoft.jultragame.binding.swing.UGSwing;
import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGStuffDelegate;
import com.gollersoft.jultragame.core.display.UGColor;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.core.display.UGImage;
import com.gollersoft.jultragame.core.display.UGRenderDelegate;
import com.gollersoft.jultragame.core.event.UGKeyEvent;
import com.gollersoft.jultragame.core.event.UGKeyboardDelegate;

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
        frame.setLayout(new BorderLayout());
        ug.display.setRenderDelegate(new UGRenderDelegate() {
            final UGColor black = new UGColor(0, 0, 0);
            final UGColor red = new UGColor(255, 0, 0);
            final UGColor white = new UGColor(255, 255, 255);
            int width, height;

            @Override
            public void draw(UGGraphics g) {
                g.fillRect(0, 0, width, height, white);
                g.drawImage(img, position.x, position.y, 32, 0, 32, 32);
                g.drawImage(img, width - 32, height - 32, 32, 32, 32, 32);
                g.drawRect(60, 60, 100, 100, red);
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
        ug.stuffDelegate = new UGStuffDelegate() {
            @Override
            public void frame() {
                position.x += speed.x;
                position.y += speed.y;
            }
        };

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.requestFocus();
    }
}
