package com.gollersoft.jultragame.layer;

import com.gollersoft.jultragame.core.UGFinalDimension;
import com.gollersoft.jultragame.core.display.UGCamera;
import com.gollersoft.jultragame.core.display.UGGraphics;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/24/12
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGTileLayer implements UGLayer {
    final UGTiles tiles;
    final UGCamera camera;

    public UGTileLayer(UGTiles tiles, UGCamera camera) {
        this.tiles = tiles;
        this.camera = camera;
    }

    @Override
    public void draw(UGGraphics g) {
        final UGFinalDimension levelSize = tiles.getSize();
        final int levelWidth = levelSize.width;
        final int levelHeight = levelSize.height;
        final int tileWidth = tiles.getSize().width;
        final int tileHeight = tiles.getSize().height;
        for (int y = 0; y < levelHeight; y++) {
            for (int x = 0; x < levelWidth; x++) {
                final int tileX = x * tileWidth - camera.x;
                final int tileY = y * tileHeight - camera.y;
                tiles.drawTile(g, x, y, tileX, tileY);
            }
        }
    }

    @Override
    public void frame() {
        tiles.frame();
    }
}
