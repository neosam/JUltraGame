package com.gollersoft.jultragame.core.event;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/24/12
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGMouseClickEvent {
    public final int button;
    public final int x, y;

    public UGMouseClickEvent(int button, int x, int y) {
        this.button = button;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "UGMouseClickEvent{" +
                "button=" + button +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
