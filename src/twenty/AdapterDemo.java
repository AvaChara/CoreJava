package twenty;

import java.applet.Applet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class AdapterDemo extends Applet{
    @Override
    public void init() {
        addMouseListener(new MyMouseAdapter(this));
        addMouseMotionListener(new MyMouseMotionAdapter(this));
    }

    private class MyMouseAdapter extends MouseAdapter {
        AdapterDemo adapterDemo;
        public MyMouseAdapter(AdapterDemo adapterDemo){
            this.adapterDemo=adapterDemo;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            adapterDemo.showStatus("click");
        }
    }

    private class MyMouseMotionAdapter extends MouseMotionAdapter {
        AdapterDemo adapterDemo;
        public MyMouseMotionAdapter(AdapterDemo adapterDemo) {
            this.adapterDemo=adapterDemo;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            adapterDemo.showStatus("dragged");
        }
    }
}
