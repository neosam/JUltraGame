package com.gollersoft.jultragame.binding.swing;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGList;
import com.gollersoft.jultragame.core.UGMap;
import com.gollersoft.jultragame.core.display.UGImage;
import com.gollersoft.jultragame.core.event.UGKeyEvent;
import com.gollersoft.jultragame.core.event.UGKeyboardDelegate;
import com.gollersoft.jultragame.binding.swing.display.SwingDisplay;
import com.gollersoft.jultragame.binding.swing.display.SwingImage;
import com.gollersoft.jultragame.core.event.UGMouseClickEvent;
import com.gollersoft.jultragame.core.event.UGMouseDelegate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSwing extends UG {

    public UGSwing(int w, int h) {
        super(new SwingDisplay(w, h));

        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(33);
                        stuffDelegate.frame();
                        ((JPanel) display.getElement()).repaint();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

            }
        }.start();
    }

    @Override
    public void setKeyboardDelgate(final UGKeyboardDelegate delegate) {
        super.setKeyboardDelgate(delegate);
        final JPanel panel = (JPanel) display.getElement();
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                delegate.keydown(new UGKeyEvent(keyEvent.getKeyCode(), keyEvent.isControlDown(),
                        keyEvent.isAltDown(), keyEvent.isShiftDown()));
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                delegate.keyup(new UGKeyEvent(keyEvent.getKeyCode(), keyEvent.isControlDown(),
                        keyEvent.isAltDown(), keyEvent.isShiftDown()));
            }
        });
    }

    @Override
    public void setMouseDelegate(final UGMouseDelegate mouseDelegate) {
        super.setMouseDelegate(mouseDelegate);
        final JPanel panel = (JPanel) display.getElement();
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                mouseDelegate.mouseClicked(new UGMouseClickEvent(mouseEvent.getButton(),
                        mouseEvent.getX(),
                        mouseEvent.getY()));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
    }

    @Override
    public UGImage getImage(String path) {
        try {
            return new SwingImage(ImageIO.read(new File(path)));
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public UGMap createMap() {
        return new SwingMap();
    }

    @Override
    public UGList createList() {
        return new SwingList();
    }
}
