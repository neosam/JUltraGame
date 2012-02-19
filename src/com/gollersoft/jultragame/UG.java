package com.gollersoft.jultragame;

import com.gollersoft.jultragame.display.UGDisplay;
import com.gollersoft.jultragame.display.UGImage;
import com.gollersoft.jultragame.event.UGKeyboardDelegate;
import com.gollersoft.jultragame.event.UGKeycodeTranslation;
import com.gollersoft.jultragameswing.event.SwingKeycodeTranslation;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */
abstract public class UG {
    public final UGDisplay display;
    private UGKeyboardDelegate keyboardDelegate;
    public final UGKeycodeTranslation keycodeTranslation;

    protected UG(UGDisplay display) {
        this.display = display;
        keycodeTranslation = new SwingKeycodeTranslation();

    }

    public void setKeyboardDelgate(UGKeyboardDelegate delegate) {
        keyboardDelegate = delegate;
    }

    public abstract UGImage getImage(String path);
}
