package com.gollersoft.jultragameswing.display;

import com.gollersoft.jultragame.display.UGGraphics;
import com.gollersoft.jultragame.display.UGRenderDelegate;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:54 PM

 * To change this template use File | Settings | File Templates.
 */
public class UGSwingPanel extends JPanel {
    UGRenderDelegate renderDelegate;

    public UGSwingPanel(int width, int height) {
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        renderDelegate = new UGRenderDelegate() {
            @Override
            public void draw(UGGraphics g) {}
            @Override
            public void resize(int width, int height) {}
        };
    }

    public void paintComponent(Graphics g) {
        renderDelegate.draw(new SwingGraphics((Graphics2D) g));
    }
}