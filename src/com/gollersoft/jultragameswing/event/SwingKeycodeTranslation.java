package com.gollersoft.jultragameswing.event;

import com.gollersoft.jultragame.event.UGKeycode;
import com.gollersoft.jultragame.event.UGKeycodeTranslation;

import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 2:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwingKeycodeTranslation implements UGKeycodeTranslation {
    @Override
    public UGKeycode translateKeyCode(int code) {
        switch (code) {
            case KeyEvent.VK_UP:
                return UGKeycode.up;
            case KeyEvent.VK_DOWN:
                return UGKeycode.down;
            case KeyEvent.VK_LEFT:
                return UGKeycode.left;
            case KeyEvent.VK_RIGHT:
                return UGKeycode.right;
            default:
                return null;
        }
    }
}
