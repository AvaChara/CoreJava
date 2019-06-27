package twenty;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyEvents extends Applet implements KeyListener {
    String string="";
    int x=10,y=20;

    @Override
    public void init() {
        addKeyListener(this);
        requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        string+=e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        showStatus("down");
        int key=e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_F1:
                string+="<F1>";
                break;
            case KeyEvent.VK_F2:
                string+="<F2>";
                break;
            case KeyEvent.VK_F3:
                string+="<F3>";
                break;
            case KeyEvent.VK_DOWN:
                string+="<PgDn>";
                break;
            case KeyEvent.VK_UP:
                string+="<PgUp>";
                break;
            case KeyEvent.VK_LEFT:
                string+="<left arrow>";
                break;
            case KeyEvent.VK_RIGHT:
                string+="<right arrow>";
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        showStatus("up");
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(string,x,y);
    }
}
