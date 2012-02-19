package com.gollersoft.jultragameswing;

import com.gollersoft.jultragame.UG;
import com.gollersoft.jultragameswing.display.SwingDisplay;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSwing extends UG {
    public UGSwing(int w, int h) {
        super(new SwingDisplay(w, h));
    }
}
