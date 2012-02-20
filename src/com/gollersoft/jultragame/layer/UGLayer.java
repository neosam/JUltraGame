package com.gollersoft.jultragame.layer;

import com.gollersoft.jultragame.core.display.UGGraphics;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/20/12
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UGLayer {
    abstract void draw(UGGraphics g);
    abstract void frame();
}
