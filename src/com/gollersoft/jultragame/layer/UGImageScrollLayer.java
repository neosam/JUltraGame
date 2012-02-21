package com.gollersoft.jultragame.layer;

import com.gollersoft.jultragame.core.display.UGCamera;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.core.display.UGImage;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/21/12
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGImageScrollLayer implements UGLayer {
    private UGImage image;
    private UGCamera camera;

    public UGImageScrollLayer(UGImage image, UGCamera camera) {
        this.image = image;
        this.camera = camera;
    }

    @Override
    public void draw(UGGraphics g) {
        g.drawImage(image, -camera.x, -camera.y);
    }

    @Override
    public void frame() {
    }
}
