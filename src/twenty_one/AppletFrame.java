package twenty_one;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class SampleFrame extends Frame {
    SampleFrame(String title) {
        super(title);
        MyWindowAdapter adapter = new MyWindowAdapter(this);
        addWindowListener(adapter);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("frame window", 10, 40);
    }
}
    class MyWindowAdapter extends WindowAdapter{
        SampleFrame sampleFrame;
        public MyWindowAdapter(SampleFrame sampleFrame) {
            this.sampleFrame=sampleFrame;
        }
        @Override
        public void windowClosed(WindowEvent e) {
            sampleFrame.setVisible(false);
        }
    }

    public class AppletFrame extends Applet{
        Frame f;

        @Override
        public void init() {
            f=new SampleFrame("A frame window");
            f.setSize(250,250);
            f.setVisible(true);
        }

        @Override
        public void start() {
            f.setVisible(true);
        }

        @Override
        public void stop() {
            f.setVisible(false);
        }

        @Override
        public void paint(Graphics g) {
            g.drawString("applet window",10,20);
        }
    }
