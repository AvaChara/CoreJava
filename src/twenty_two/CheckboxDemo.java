package twenty_two;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxDemo extends Applet implements ItemListener {
    String msg="";
    Checkbox Win98,winNT,solaris,mac;

    @Override
    public void init() {
        Win98=new Checkbox("Window 98",null,true);
        winNT=new Checkbox("Windows Nt/2000");
        solaris=new Checkbox("Solaris");
        mac=new Checkbox("MacOS");

        add(Win98);
        add(winNT);
        add(solaris);
        add(mac);

        Win98.addItemListener(this);
        winNT.addItemListener(this);
        solaris.addItemListener(this);
        mac.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        msg="Current state:";
        g.drawString(msg,6,80);
        msg=" Window 98:"+Win98.getState();
        g.drawString(msg,6,100);
        msg=" Windows Nt/2000:"+winNT.getState();
        g.drawString(msg,6,120);
        msg=" Solaris:"+solaris.getState();
        g.drawString(msg,6,140);
        msg=" MacOS:"+mac.getState();
        g.drawString(msg,6,160);

    }
}
