package twenty;

import java.applet.Applet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePressedDemo extends Applet{
    @Override
    public void init() {
        addMouseListener(new MyMouseAdapter(this));
    }

    private class MyMouseAdapter extends MouseAdapter {
        MousePressedDemo mousePressedDemo;
        public MyMouseAdapter(MousePressedDemo mousePressedDemo) {
            this.mousePressedDemo=mousePressedDemo;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            mousePressedDemo.showStatus("press");
        }
    }
}
