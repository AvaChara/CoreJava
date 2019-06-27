package nineteen;

import java.applet.Applet;
import java.awt.*;

public class Sample extends Applet{
    String msg;

    @Override
    public void init() {
        setBackground(Color.BLUE);
        setForeground(Color.red);
        msg="Inside init()--";
    }

    @Override
    public void start() {
        msg+=" Inside start() --";
    }

    @Override
    public void paint(Graphics g) {
        msg+=" Inside paint().";
        g.drawString(msg,10,100);
    }
}
