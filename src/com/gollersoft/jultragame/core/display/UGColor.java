package com.gollersoft.jultragame.core.display;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGColor {
    public final int r;
    public final int g;
    public final int b;
    public final int a;

    public UGColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;
    }

    public UGColor(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }
}
