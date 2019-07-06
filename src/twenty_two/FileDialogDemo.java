package twenty_two;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FileDialogDemo {
    public static void main(String args[]){
        Frame frame=new SampleFrame("File Dialog Demo") ;
        frame.setVisible(true);
        frame.setSize(100,100);
        FileDialog fileDialog=new FileDialog(frame,"File Dialog");
        fileDialog.setVisible(true);
    }
}
class SampleFrame extends Frame {
    public SampleFrame(String title) {
        super(title);
        MyWindowAdapter2 adapter2=new MyWindowAdapter2(this);
        addWindowListener( adapter2);
    }


}
class MyWindowAdapter2 extends WindowAdapter{
    SampleFrame sampleFrame;
    public MyWindowAdapter2(SampleFrame sampleFrame) {
        this.sampleFrame=sampleFrame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        sampleFrame.setVisible(false);
    }
}
