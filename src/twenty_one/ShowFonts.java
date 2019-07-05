package twenty_one;

import java.applet.Applet;
import java.awt.*;

public class ShowFonts extends Applet{
    @Override
    public void paint(Graphics g) {
        String msg="";
        String FontList[];

        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        FontList=ge.getAvailableFontFamilyNames();
        for (int i = 0; i <FontList.length ; i++) {
            msg+=FontList[i]+" ";
        }
        g.drawString(msg,4,16);
    }
}
