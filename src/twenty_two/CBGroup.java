package twenty_two;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CBGroup extends Applet implements ItemListener {
    String msg="";
    Checkbox Win98,winNT,solaris,mac;
    CheckboxGroup cbg=new CheckboxGroup();

    @Override
    public void init() {
        Win98=new Checkbox("Window 98",true,cbg);
        winNT=new Checkbox("Windows Nt/2000",false,cbg);
        solaris=new Checkbox("Solaris",false,cbg);
        mac=new Checkbox("MacOS",false,cbg);

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
        msg="Current selection:";
        msg += cbg.getSelectedCheckbox().getLabel();
        g.drawString(msg,6,100);
    }
}
