package com.gollersoft.jultragameswing;

import com.gollersoft.jultragame.UG;
import com.gollersoft.jultragame.event.UGKeyEvent;
import com.gollersoft.jultragame.event.UGKeyboardDelegate;
import com.gollersoft.jultragameswing.display.SwingDisplay;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
}
