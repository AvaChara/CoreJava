package twenty;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SimpleKey extends Applet implements KeyListener {
    String msg="";
    int x=10,y=20;

    @Override
    public void init() {
        addKeyListener(this);
        requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        msg+=e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        showStatus("Key Down");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        showStatus("Key Up");
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,x,y);
    }
}
