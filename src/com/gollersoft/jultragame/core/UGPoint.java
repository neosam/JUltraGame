package com.gollersoft.jultragame.core;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGPoint {
    public int x, y;

    public UGPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public UGPoint() {
    }

    @Override
    public String toString() {
        return "UGPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
