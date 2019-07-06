package twenty_two;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceDemo extends Applet implements ItemListener{
    Choice os,browser;
    String msg="";

    @Override
    public void init() {
        os=new Choice();
        browser=new Choice();

        os.add("Window 98");
        os.add("Windows NT/2000");
        os.add("Solaris");
        os.add("MacOS");

        browser.add("Netscape 1.1");
        browser.add("Netscape 2.x");
        browser.add("Netscape 3.x");
        browser.add("Netscape 4.x");

        browser.add("Internet Explorer 3.0");
        browser.add("Internet Explorer 4.0");
        browser.add("Internet Explorer 5.0");

        browser.add("Lybx 2.4");
        browser.select("Netscape 4.x");

        add(os);
        add(browser);
        os.addItemListener(this);
        browser.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        msg="Current OS:";
        msg+=os.getSelectedItem();
        g.drawString(msg,6,120);
        msg="Current Browser: ";
        msg+=browser.getSelectedItem();
        g.drawString(msg,6,140);
    }
}