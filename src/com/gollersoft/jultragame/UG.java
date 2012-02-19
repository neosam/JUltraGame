package com.gollersoft.jultragame;

import com.gollersoft.jultragame.display.UGDisplay;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */
abstract public class UG {
    public final UGDisplay display;

    protected UG(UGDisplay display) {
        this.display = display;
    }
}
