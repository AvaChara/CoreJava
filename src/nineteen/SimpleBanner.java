package nineteen;

import java.applet.Applet;
import java.awt.*;

public class SimpleBanner extends Applet implements Runnable{
    String msg="A Simple Moving Banner";
    Thread t=null;
    int state;
    boolean stopFlag;

    @Override
    public void init() {
        setBackground(Color.cyan);
        setForeground(Color.red);
    }

    @Override
    public void start() {
        t=new Thread(this);
        stopFlag=false;
        t.start();
    }

    @Override
    public void run() {
        char ch;
        for (;;){
            try{
                repaint();
                Thread.sleep(1000);
                ch=msg.charAt(0);
                msg=msg.substring(1,msg.length());
                msg+=ch;
                if (stopFlag)
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stop() {
        stopFlag=true;
        t=null;
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,50,30);
    }
}
