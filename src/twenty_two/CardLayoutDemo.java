package twenty_two;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutDemo extends Applet implements ActionListener,MouseListener {
    Checkbox Win98,winNT,solaris,mac;
    Panel osCards;
    CardLayout cardLayout;
    Button Win,Other;

    @Override
    public void init() {
        Win=new Button("Windows");
        Other =new Button("Other");
        add(Win);
        add(Other);

        cardLayout=new CardLayout();
        osCards=new Panel();
        osCards.setLayout(cardLayout);

        Win98=new Checkbox("Window 98",null,true);
        winNT=new Checkbox("Windows Nt/2000");
        solaris=new Checkbox("Solaris");
        mac=new Checkbox("MacOS");

        Panel winPan=new Panel();
        winPan.add(Win98);
        winPan.add(winNT);

        Panel otherPan=new Panel();
        otherPan.add(solaris);
        otherPan.add(mac);

        osCards.add(winPan,"Windows");
        osCards.add(otherPan,"Other");

        add(osCards);

        Win.addActionListener(this);
        Other.addActionListener(this);

        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        cardLayout.next(osCards);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Win)
            cardLayout.show(osCards,"Windows");
        else
            cardLayout.show(osCards,"Other");
    }

}
