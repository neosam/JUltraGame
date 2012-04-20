package com.gollersoft.jultragame.jultragameswingtest;

import com.gollersoft.jultragame.binding.swing.UGSwing;
import com.gollersoft.jultragame.core.UG;

/**
 * Created with IntelliJ IDEA.
 * User: neosam-code
 * Date: 4/19/12
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Soundtest {
    public static void main(String[] args) throws InterruptedException {
        UG ug = new UGSwing(600, 400);
        System.out.println("Bla");
        ug.playMusic("test.wav");
        Thread.sleep(5000);
        ug.playSoundfile("test.ogg");
    }
}
