package com.gollersoft.jultragameswing.display;

import com.gollersoft.jultragame.display.UGDisplay;
import com.gollersoft.jultragame.display.UGRenderDelegate;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwingDisplay extends UGDisplay {
    private final UGSwingPanel panel;

    SwingDisplay(int width, int height) {
        panel = new UGSwingPanel(width, height);
    }

    @Override
    public Object getElement() {
        return panel;
    }

    @Override
    protected void resizeEvent() {
        panel.setSize(width, height);
    }

    public void setRenderDelegate(UGRenderDelegate renderDelegate) {
        super.setRenderDelegate(renderDelegate);
        panel.renderDelegate = renderDelegate;
    }
}
