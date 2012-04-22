package com.gollersoft.jultragame.layer;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGList;
import com.gollersoft.jultragame.core.display.UGGraphics;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/20/12
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGLayerList implements UGList<UGLayer>, UGLayer {
    private final UGList<UGLayer> layers;

    public UGLayerList(UG ug) {
        layers = ug.createList();
    }

    @Override
    public int size() {
        return layers.size();
    }

    @Override
    public void add(UGLayer ugLayer) {
        layers.add(ugLayer);
    }

    @Override
    public UGLayer at(int i) {
        return layers.at(i);
    }

    @Override
    public void remove(UGLayer ugLayer) {
        layers.remove(ugLayer);
    }

    public void draw(UGGraphics g) {
        for (int i = 0; i < layers.size(); i++)
            layers.at(i).draw(g);
    }

    @Override
    public void frame() {
        for (int i = 0; i < layers.size(); i++)
            layers.at(i).frame();
    }

}
