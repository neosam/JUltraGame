package com.gollersoft.jultragame.core;

import com.gollersoft.jultragame.core.display.UGDisplay;
import com.gollersoft.jultragame.core.display.UGImage;
import com.gollersoft.jultragame.core.event.UGKeyboardDelegate;
import com.gollersoft.jultragame.core.event.UGKeycodeTranslation;
import com.gollersoft.jultragame.binding.swing.event.SwingKeycodeTranslation;
import com.gollersoft.jultragame.core.event.UGMouseDelegate;

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
    private UGMouseDelegate mouseDelegate;
    public final UGKeycodeTranslation keycodeTranslation;
    public UGStuffDelegate stuffDelegate;

    protected UG(UGDisplay display) {
        this.display = display;
        keycodeTranslation = new SwingKeycodeTranslation();
        stuffDelegate = new UGStuffDelegate() {
            @Override
            public void frame() {
                // nothing
            }
        };
    }

    public void setKeyboardDelgate(UGKeyboardDelegate delegate) {
        keyboardDelegate = delegate;
    }

    public void setMouseDelegate(UGMouseDelegate mouseDelegate) {
        this.mouseDelegate = mouseDelegate;
    }

    public abstract UGImage getImage(String path);
    public abstract UGMap createMap();
    public abstract UGList createList();
}
