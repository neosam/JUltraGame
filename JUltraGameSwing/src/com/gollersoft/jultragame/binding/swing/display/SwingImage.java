package com.gollersoft.jultragame.binding.swing.display;

import com.gollersoft.jultragame.core.display.UGImage;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwingImage implements UGImage {
    public final Image image;

    public SwingImage(Image image) {
        this.image = image;
    }
}
