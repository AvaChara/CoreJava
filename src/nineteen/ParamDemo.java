package nineteen;

import java.applet.Applet;
import java.awt.*;

/*
<applet code="ParamDemo" width=300 height=50>
<param name=fontName value=Courier>
<param name=fontSize value=14>
<param name=accountEnabled value=true>
</applet>
 */
public class ParamDemo extends Applet{
    String fontName;
    int fontSize;
    float leading;
    boolean active;

    @Override
    public void start() {
        String param;
        fontName=getParameter("fontName");
        if (fontName==null)
            fontName="Not found";

        param=getParameter("fontSize");
        try{
            if (param!=null)
                fontSize=Integer.parseInt(param);
            else
                fontSize=0;
        }catch (NumberFormatException e){
            fontSize=-1;
        }

        param=getParameter("leading");
        try {
            if (param != null) {
                leading=Float.valueOf(param).floatValue();
            }else
                leading=0;
        }catch (NumberFormatException e){
            leading=-1;
        }

        param=getParameter("accountEnabled");
        if (param != null) {
            active=Boolean.valueOf(param).booleanValue();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Font name: "+fontName,0,10);
        g.drawString("Font size: "+fontSize,0,26);
        g.drawString("Leading: "+leading,0,42);
        g.drawString("Account Active: "+active,0,58);
    }
}
