package com.gollersoft.jultragame.core;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGFinalPoint {
    public final int x, y;

    public UGFinalPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public UGFinalPoint(UGPoint point) {
        this.x = point.x;
        this.y = point.y;
    }
}
