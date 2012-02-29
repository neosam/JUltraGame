package com.gollersoft.jultragame.sprite;

import com.gollersoft.jultragame.core.UGFinalRect;
import com.gollersoft.jultragame.core.UGPoint;
import com.gollersoft.jultragame.core.display.UGCamera;
import com.gollersoft.jultragame.core.display.UGGraphics;
import com.gollersoft.jultragame.core.display.UGImage;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 8:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSprite {
    private UGSpriteAnimation currentAnimation;
    private final UGSpriteAnimationStorage animationStorage;
    private final UGImage graphics;

    private UGPoint pos;

    public UGSprite(UGImage graphics, UGSpriteAnimationStorage animationStorage) {
        this.animationStorage = animationStorage;
        this.graphics = graphics;
        currentAnimation = animationStorage.get("default");
    }

    public void step() {
        currentAnimation.step();
    }

    public void setAnimation(String animation) {
        final UGSpriteAnimation tmp = animationStorage.get(animation);
        if (tmp != null) currentAnimation = tmp;
    }

    public void draw(UGGraphics g, UGCamera camera) {
        final UGFinalRect drawingRect = currentAnimation.getPosition();
        g.drawImage(graphics, pos.x - camera.x, pos.y - camera.y,
                drawingRect.x, drawingRect.y,
                drawingRect.width, drawingRect.height);
    }

    public UGPoint getPos() {
        return pos;
    }

    public void setPos(UGPoint pos) {
        this.pos = pos;
    }

    public UGFinalRect getSpriteRect() {
        final UGFinalRect size = currentAnimation.getPosition();

        return new UGFinalRect(pos.x, pos.y, size.width, size.height);
    }
}
