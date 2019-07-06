package twenty_two;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo extends Applet implements ActionListener{
    String msg="";
    Button yes,no,maybe;

    @Override
    public void init() {
        yes=new Button("YES");
        no=new Button("No");
        maybe=new Button("Undecided");

        add(yes);
        add(no);
        add(maybe);

        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str=e.getActionCommand();
        if (str.equals("YES")) {
            msg="yes";
        }else if (str.equals("No")){
            msg="no";
        }else {
            msg="undecided";
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,6,100);
    }
}
