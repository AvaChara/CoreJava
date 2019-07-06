package twenty_two;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListDemo extends Applet implements ActionListener {
    List os,browser;
    String msg="";

    @Override
    public void init() {
        os=new List(4,true);
        browser=new List(4,false);

        os.add("Window 98");
        os.add("Windows NT/2000");
        os.add("Solaris");
        os.add("MacOS");
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
        browser.select(1);

        add(os);
        add(browser);
        os.addActionListener(this);
        browser.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        int idex[];
        msg="Current OS :";
        idex=os.getSelectedIndexes();
        for (int i = 0; i < idex.length; i++) {
            msg+=os.getItem(idex[i])+" ";
        }
        g.drawString(msg,6,120);
        msg="Current Browser: ";
        msg+=browser.getSelectedItem();
        g.drawString(msg,6,140);
    }
}
