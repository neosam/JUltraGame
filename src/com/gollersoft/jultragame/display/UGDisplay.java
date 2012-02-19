package com.gollersoft.jultragame.display;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:27 PM
 * To change this template use File | Settings | File Templates.
 */
abstract public class UGDisplay {
    private UGRenderDelegate renderDelegate;
    protected int width, height;

    public abstract Object getElement();
    protected abstract void resizeEvent();

    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
        resizeEvent();
        renderDelegate.resize(width, height);
    }

    public UGRenderDelegate getRenderDelegate() {
        return renderDelegate;
    }

    public void setRenderDelegate(UGRenderDelegate renderDelegate) {
        this.renderDelegate = renderDelegate;
    }
}
