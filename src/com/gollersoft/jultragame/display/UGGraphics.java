package com.gollersoft.jultragame.display;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UGGraphics {
    void drawRect(int x, int y, int width, int height, UGColor color);
    void drawImage(UGImage image, int x, int y);
}
