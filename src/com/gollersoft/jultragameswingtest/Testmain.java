package com.gollersoft.jultragameswingtest;

import com.gollersoft.jultragame.UG;
import com.gollersoft.jultragame.display.UGColor;
import com.gollersoft.jultragame.display.UGGraphics;
import com.gollersoft.jultragame.display.UGRenderDelegate;
import com.gollersoft.jultragame.event.UGKeyEvent;
import com.gollersoft.jultragame.event.UGKeyboardDelegate;
import com.gollersoft.jultragameswing.UGSwing;

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
        frame.setLayout(new BorderLayout());
        ug.display.setRenderDelegate(new UGRenderDelegate() {
            final UGColor black = new UGColor(0, 0, 0);
            final UGColor red = new UGColor(255, 0, 0);

            @Override
            public void draw(UGGraphics g) {
                g.drawRect(position.x, position.y, 32, 32, black);
                g.drawRect(60, 60, 100, 100, red);
            }

            @Override
            public void resize(int width, int height) {
            }
        });
        ug.setKeyboardDelgate(new UGKeyboardDelegate() {
            @Override
            public void keydown(UGKeyEvent event) {
                switch (ug.keycodeTranslation.translateKeyCode(event.keycode)) {
                    case up:
                        position.y -= 10;
                        break;
                    case down:
                        position.y += 10;
                        break;
                    case left:
                        position.x -= 10;
                        break;
                    case right:
                        position.x += 10;
                        break;
                }
            }

            @Override
            public void keyup(UGKeyEvent event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.requestFocus();
    }
}
