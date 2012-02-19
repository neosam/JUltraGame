package com.gollersoft.sprite;

import com.gollersoft.jultragame.core.UGFinalRect;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/19/12
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSpriteAnimation {
    final UGFinalRect begin;
    final int offset;
    final int length;

    private int x;
    private int next;

    private int counter;
    private int step;

    public UGSpriteAnimation(UGFinalRect begin, int offset, int length) {
        this.begin = begin;
        this.offset = offset;
        this.length = length;
        x = begin.x;
        next = 1;
        counter = 0;
        step = 0;
    }

    public void step() {
        counter++;
        if (counter >= next) {
            step++;
            if (step >= length) {
                x = begin.x;
                step = 0;
            } else {
                counter = 0;
                x += offset + begin.width;
            }
        }
    }

   public UGFinalRect getPosition() {
       return new UGFinalRect(x, begin.y, begin.width, begin.height);
   }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x > 0 && x < length)
        this.x = x;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        if (next > 0)
            this.next = next;
    }
}
