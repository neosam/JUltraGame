package com.gollersoft.jultragame.core;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGFinalRect {
    final public int x, y, width, height;

    public UGFinalRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public UGFinalRect(UGRect rect) {
        this.x = rect.x;
        this.y = rect.y;
        this.width = rect.width;
        this.height = rect.height;
    }

    @Override
    public String toString() {
        return "UGFinalRect{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
