package com.gollersoft.jultragame.binding.swing.display;

import com.gollersoft.jultragame.core.display.UGColor;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.core.display.UGImage;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwingGraphics implements UGGraphics {
    private final Graphics2D g;

    public SwingGraphics(Graphics2D g) {
        this.g = g;
    }

    @Override
    public void drawRect(int x, int y, int width, int height, UGColor color) {
        g.setColor(new Color(color.r, color.b, color.b));
        g.drawRect(x, y, width, height);
    }

    @Override
    public void fillRect(int x, int y, int width, int height, UGColor color) {
        g.setColor(new Color(color.r, color.b, color.b));
        g.fillRect(x, y, width, height);
    }

    @Override
    public void drawImage(UGImage image, int x, int y) {
        g.drawImage(((SwingImage)image).image, x, y, null);
    }

    @Override
    public void drawImage(UGImage image, int x, int y, int xBegin, int yBegin, int width, int height) {
        g.drawImage(((SwingImage)image).image, x, y, x + width, y + height,
                xBegin, yBegin, xBegin + width, yBegin + height, null);
    }
}
