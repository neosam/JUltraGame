package com.gollersoft.jultragame.binding.swing;

import com.gollersoft.jultragame.binding.swing.event.SwingKeycodeTranslation;
import com.gollersoft.jultragame.core.UG;
import com.gollersoft.jultragame.core.UGList;
import com.gollersoft.jultragame.core.UGMap;
import com.gollersoft.jultragame.core.display.UGImage;
import com.gollersoft.jultragame.core.event.UGKeyEvent;
import com.gollersoft.jultragame.core.event.UGKeyboardDelegate;
import com.gollersoft.jultragame.binding.swing.display.SwingDisplay;
import com.gollersoft.jultragame.binding.swing.display.SwingImage;
import com.gollersoft.jultragame.core.event.UGMouseClickEvent;
import com.gollersoft.jultragame.core.event.UGMouseDelegate;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecJOgg;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryJavaSound;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: neosam
 * Date: 2/18/12
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class UGSwing extends UG {
    private SoundSystem soundSystem = null;


    public UGSwing(int w, int h) {
        super(new SwingDisplay(w, h));
        keycodeTranslation = new SwingKeycodeTranslation();

        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(33);
                        stuffDelegate.frame();
                        ((JPanel) display.getElement()).repaint();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

            }
        }.start();
    }

    @Override
    public void setKeyboardDelgate(final UGKeyboardDelegate delegate) {
        super.setKeyboardDelgate(delegate);
        final JPanel panel = (JPanel) display.getElement();
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                delegate.keydown(new UGKeyEvent(keyEvent.getKeyCode(), keyEvent.isControlDown(),
                        keyEvent.isAltDown(), keyEvent.isShiftDown()));
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                delegate.keyup(new UGKeyEvent(keyEvent.getKeyCode(), keyEvent.isControlDown(),
                        keyEvent.isAltDown(), keyEvent.isShiftDown()));
            }
        });
    }

    @Override
    public void setMouseDelegate(final UGMouseDelegate mouseDelegate) {
        super.setMouseDelegate(mouseDelegate);
        final JPanel panel = (JPanel) display.getElement();
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                mouseDelegate.mouseClicked(new UGMouseClickEvent(mouseEvent.getButton(),
                        mouseEvent.getX(),
                        mouseEvent.getY()));
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
    }

    @Override
    public UGImage getImage(String path) {
        try {
            return new SwingImage(ImageIO.read(new File(path)));
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public UGMap createMap() {
        return new SwingMap();
    }

    @Override
    public UGList createList() {
        return new SwingList();
    }

    private void initSound() {
        if (soundSystem == null) {
            System.out.println("init sound");
            try {

                SoundSystemConfig.addLibrary(LibraryJavaSound.class);
                SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
                SoundSystemConfig.setCodec("wav", CodecWav.class);

            } catch (SoundSystemException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            soundSystem = new SoundSystem();
        }
    }

    @Override
    public void playMusic(String filename) {
        initSound();
        try {
            soundSystem.backgroundMusic("music", new File(filename).toURL(), filename, true);
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public void playSoundfile(String filename) {
        initSound();
        try {
            soundSystem.quickPlay(true, new File(filename).toURL(), filename, false, 0, 0, 0, 0, 0);
        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
