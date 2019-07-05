package twenty_one;

import java.applet.Applet;
import java.awt.*;

public class CenterText extends Applet{
    final Font font=new Font("Amano",Font.BOLD,18);

    @Override
    public void paint(Graphics g) {
        Dimension d=this.getSize();
        g.setColor(Color.white);
        g.fillRect(0,0,d.width,d.height);
        g.setColor(Color.black);
        g.setFont(font);
        drawCenteredString("This is centered.",d.width,d.height,g);
        g.drawRect(0,0,d.width-1,d.height-1);
    }
    public void drawCenteredString(String s,int w,int h,Graphics g){
        FontMetrics fontMetrics=g.getFontMetrics();
        int x=(w-fontMetrics.stringWidth(s))/2;
        int y= (fontMetrics.getAscent()+(h-(fontMetrics.getAscent()+ fontMetrics.getDescent())) /2);
        g.drawString(s,x,y);
    }
}
