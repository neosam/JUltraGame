package com.gollersoft.jultragame.collision;

import com.gollersoft.jultragame.core.UGFinalPoint;
import com.gollersoft.jultragame.core.UGFinalRect;
import com.gollersoft.jultragame.core.UGPoint;
import com.gollersoft.jultragame.core.UGRect;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/24/12
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Collision {
    public boolean pointInRect(UGFinalPoint point, UGFinalRect rect) {
        final int diffX = rect.x - point.x;
        final int diffY = rect.y - point.y;
        return (diffX >= 0 && diffY >= 0 && diffX < rect.width && diffY < rect.height);
    }

    public boolean pointInRect(UGPoint point, UGFinalRect rect) {
        return pointInRect(new UGFinalPoint(point), rect);
    }

    public boolean pointInRect(UGFinalPoint point, UGRect rect) {
        return pointInRect(point, new UGFinalRect(rect));
    }

    public boolean pointInRect(UGPoint point, UGRect rect) {
        return pointInRect(new UGFinalPoint(point), new UGFinalRect(rect));
    }
}
