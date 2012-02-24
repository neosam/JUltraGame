package com.gollersoft.jultragame.layer;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/24/12
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGTile {
    private final int x, y;


    public UGTile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void frame() {
        /* not needed in this static tile class */
    }
}
