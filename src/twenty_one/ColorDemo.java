package twenty_one;

import java.applet.Applet;
import java.awt.*;

public class ColorDemo extends Applet{
    @Override
    public void paint(Graphics g) {
        Color c1=new Color(255,100,100);
        Color c2=new Color(100,255,100);
        Color c3=new Color(100,100,255);

        g.setColor(c1);
        g.drawLine(0,0,100,100);
        g.drawLine(0,100,100,0);

        g.setColor(c2);
        g.drawLine(40,25,100,100);
        g.drawLine(75,90,100,0);

        g.setColor(c3);
        g.drawLine(20,150,100,100);
        g.drawLine(5,290,100,0);

        g.setColor(Color.red);
        g.drawOval(10,10,50,50);
        g.fillOval(70,90,140,100);

        g.setColor(Color.blue);
        g.drawOval(190,10,90,30);
        g.fillRect(10,10,60,50);

        g.setColor(Color.cyan);
        g.fillRect(100,10,60,50);
        g.drawRoundRect(190,10,60,50,15,15);

    }
}
