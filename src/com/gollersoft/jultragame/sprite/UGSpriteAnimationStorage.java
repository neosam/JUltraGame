package com.gollersoft.jultragame.sprite;

import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGMap;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSpriteAnimationStorage implements UGMap<String, UGSpriteAnimation> {
    private final UGMap<String, UGSpriteAnimation> map;

    public UGSpriteAnimationStorage(UG ug) {
        map = ug.createMap();
    }


    @Override
    public void put(String s, UGSpriteAnimation ugSpriteAnimation) {
        map.put(s, ugSpriteAnimation);
    }

    @Override
    public UGSpriteAnimation get(String s) {
        return map.get(s);
    }
}
