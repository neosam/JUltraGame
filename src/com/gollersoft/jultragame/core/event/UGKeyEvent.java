package com.gollersoft.jultragame.core.event;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class UGKeyEvent {
    public final int keycode;
    public final boolean ctrlDown;
    public final boolean altDown;
    public final boolean shiftDown;

    public UGKeyEvent(int keycode, boolean ctrlDown, boolean altDown, boolean shiftDown) {
        this.keycode = keycode;
        this.ctrlDown = ctrlDown;
        this.altDown = altDown;
        this.shiftDown = shiftDown;
    }
}
