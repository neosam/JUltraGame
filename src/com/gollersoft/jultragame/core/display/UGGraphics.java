package com.gollersoft.jultragame.core.display;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UGGraphics {
    void drawRect(int x, int y, int width, int height, UGColor color);
    void fillRect(int x, int y, int width, int height, UGColor color);
    void drawImage(UGImage image, int x, int y);
    void drawImage(UGImage image, int x, int y, int xBegin, int yBegin, int width, int height);
    void drawString(String text, int x, int y, UGColor color);
    void drawCircle(int x, int y, int radius, UGColor color);
    void fillCircle(int x, int y, int radius, UGColor color);
}
