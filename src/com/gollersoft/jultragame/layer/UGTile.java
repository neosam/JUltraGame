package com.gollersoft.jultragame.layer;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/24/12
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGTile {
    final private int x, y;
    final private boolean visible = true;
    final private boolean walkable = true;


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

    public boolean isVisible() {
        return visible;
    }

    public boolean isWalkable() {
        return walkable;
    }
}
