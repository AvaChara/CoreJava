package twenty_two;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class SBDemo extends Applet implements AdjustmentListener, MouseMotionListener{

    String msg="";
    Scrollbar vertSB,horzSB;

    @Override
    public void init() {
        int width=getWidth();
        int height=getHeight();

        vertSB=new Scrollbar(Scrollbar.VERTICAL,0,1,0,height);
        horzSB=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,width);

        add(vertSB);
        add(horzSB);

        vertSB.addAdjustmentListener(this);
        horzSB.addAdjustmentListener(this);
        addMouseMotionListener(this);

    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        vertSB.setValue(y);
        horzSB.setValue(x);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void paint(Graphics g) {
        msg="Vertical: "+vertSB.getValue();
        msg+=", Horizontal: "+horzSB.getValue();
        g.drawString(msg,6,160);
        g.drawString("*",horzSB.getValue(),vertSB.getValue());
    }
}
