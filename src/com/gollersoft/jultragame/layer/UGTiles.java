package com.gollersoft.jultragame.layer;

import com.gollersoft.jultragame.core.UGFinalDimension;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.core.display.UGImage;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/24/12
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGTiles {
    final UGFinalDimension size;
    final UGFinalDimension tileSize;
    final UGImage images;
    final UGTile[] tiles;

    public UGTiles(UGFinalDimension size, UGImage images, UGFinalDimension tileSize) {
        this.size = size;
        this.images = images;
        this.tileSize = tileSize;
        tiles = new UGTile[size.width * size.height];
    }

    public UGTile getTileAt(int x, int y) {
        return tiles[y * size.width + x];
    }

    public void drawTile(UGGraphics g, int tileX, int tileY, int destX, int destY) {
        final UGTile tile = getTileAt(tileX, tileY);
        final int x = tile.getX() * tileSize.width;
        final int y = tile.getY() * tileSize.height;
        g.drawImage(images, destX, destY, x, y, tileSize.width, tileSize.height);
    }

    public void frame() {
        for (int i = 0; i < tiles.length; i++)
            tiles[i].frame();
    }

    public UGFinalDimension getSize() {
        return size;
    }

    public UGFinalDimension getTileSize() {
        return tileSize;
    }
}
