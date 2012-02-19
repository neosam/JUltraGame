package com.gollersoft.jultragame.display;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UGRenderDelegate {
    void draw(UGGraphics g);
    void resize(int width, int height);
}
