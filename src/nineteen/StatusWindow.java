package nineteen;

import java.applet.Applet;
import java.awt.*;

/*
<applet code="StatusWindow" width=300 height=50>
</applet>
*/
public class StatusWindow extends Applet{
    @Override
    public void init() {
        setBackground(Color.cyan);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("THis is in thhe applet window.",10,20);
        showStatus("This is shown in  the status window.");
    }
}
