package twenty_one;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

class SampleFrame1 extends Frame implements MouseListener, MouseMotionListener {
    String msg="";
    int mouseX=10,mouseY=40;
    int movX=0,movY=0;
    SampleFrame1(String title){
        super(title);
        addMouseListener(this);
        addMouseMotionListener(this);
        MyWindowAdapter1 adapter=new MyWindowAdapter1(this);
        addWindowListener(adapter);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        msg="down";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        msg="up";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent eobj) {
        mouseX=10;
        mouseY=54;
        msg="Mouse just entered child.";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent eobj) {
        mouseX=10;
        mouseY=54;
        msg="Mouse just left child window";
        repaint();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        movX=e.getX();
        movY=e.getY();
        msg="*";
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        movX=e.getX();
        movY=e.getY();
        repaint(0,0,100,60);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,mouseX,mouseY);
        g.drawString("Mouse at "+movX+","+movY,10,40);
    }
}

class MyWindowAdapter1 extends WindowAdapter{
    SampleFrame1 sampleFrame;

    public MyWindowAdapter1(SampleFrame1 sampleFrame) {
        this.sampleFrame=sampleFrame;
    }

    @Override
    public void windowClosing(WindowEvent we) {
        sampleFrame.setVisible(false);
    }
}

public class WindowEvents extends Applet implements MouseListener, MouseMotionListener {
    SampleFrame1 f;
    String msg="";
    int mouseX=0,mouseY=10;
    int movX=0,movY=0;

    @Override
    public void init() {
        f=new SampleFrame1("Handle Mouse Events");
        f.setSize(300,200);
        f.setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void stop() {
        f.setVisible(false);
    }

    @Override
    public void start() {
        f.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        msg="down";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        msg="up";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX=0;
        mouseY=24;
        msg="Mouse just entered applet window.";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseX=0;
        mouseY=24;
        msg="Mouse just left applet window.";
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        movX=e.getX();
        movY=e.getY();
        msg="*";
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        movX=e.getX();
        movY=e.getY();
        repaint(0,0,100,20);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,mouseX,mouseY);
        g.drawString("Mouse at "+movX+" ."+movY,0,10);
    }
}
