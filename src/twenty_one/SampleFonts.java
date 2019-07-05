package twenty_one;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SampleFonts extends Applet{
    int next=0;
    Font font;
    String msg;

    @Override
    public void init() {
        font=new Font("Dialog",Font.PLAIN,12);
        msg="Dialog";
        setFont(font);
        addMouseListener(new MyMouseAdapter1(this));
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,4,20);
    }
}
class MyMouseAdapter1 extends MouseAdapter{

    SampleFonts sampleFonts;
    public MyMouseAdapter1(SampleFonts sampleFonts) {
        this.sampleFonts=sampleFonts;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        sampleFonts.next++;
        switch (sampleFonts.next) {
            case 0:
                sampleFonts.font=new Font("Dialog",Font.PLAIN,12);
                sampleFonts.msg="Dialog";
                break;
            case 1:
                sampleFonts.font=new Font("Amano",Font.PLAIN,12);
                sampleFonts.msg="Amano";
                break;
            case 2:
                sampleFonts.font=new Font("SanSerif",Font.PLAIN,12);
                sampleFonts.msg="SanSerif";
                break;
            case 3:
                sampleFonts.font=new Font("Serif",Font.PLAIN,12);
                sampleFonts.msg="Serif";
                break;
            case 4:
                sampleFonts.font=new Font("Monospaced",Font.PLAIN,12);
                sampleFonts.msg="Monospaced";
                break;
        }
        if (sampleFonts.next==4)
            sampleFonts.next=-1;
        sampleFonts.setFont(sampleFonts.font);
        sampleFonts.repaint();
    }
}
