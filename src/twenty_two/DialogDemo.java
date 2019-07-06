package twenty_two;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


class SampleDialog extends Dialog implements ActionListener{
    SampleDialog(Frame parent,String title){
        super(parent,title,false);
        setLayout(new FlowLayout());
        setSize(300,200);
        add(new Label("Press this button:"));
        Button b;
        add(b=new Button("Cancel"));
        b.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("This is in the dialog box",10,70);
    }
}

class MenuFrame1 extends Frame {
    String msg = "";
    CheckboxMenuItem debug, test;

    MenuFrame1(String title) {
        super(title);
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        Menu file = new Menu("File");

        MenuItem item, item1, item2, item3;
        file.add(item = new MenuItem("New..."));
        file.add(item1 = new MenuItem("Open..."));
        file.add(item2 = new MenuItem("Close..."));
        file.add(new MenuItem("-"));
        file.add(item3 = new MenuItem("Quit..."));
        menuBar.add(file);

        Menu edit = new Menu("Edit");
        MenuItem item4,item5, item6;
        edit.add(item4 = new MenuItem("Cut"));
        edit.add(item5 = new MenuItem("Copy"));
        edit.add(item6 = new MenuItem("Paste"));
        edit.add( new MenuItem("-"));

        Menu sub = new Menu("Special");
        MenuItem item7,item8,item9;
        sub.add(item7 = new MenuItem("First"));
        sub.add(item8 = new MenuItem("Second"));
        sub.add(item9 = new MenuItem("Third"));
        edit.add(sub);

        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Testing");
        edit.add(test);

        menuBar.add(edit);

        MyMenuHandler1 handler = new MyMenuHandler1(this);
        item.addActionListener(handler);
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item5.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
        item9.addActionListener(handler);
        debug.addItemListener(handler);
        test.addItemListener(handler);

        MyWindowAdapter1 adapter = new MyWindowAdapter1(this);
        addWindowListener(adapter);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 10, 200);
        if (debug.getState())
            g.drawString("Debug is on.", 10, 220);
        else
            g.drawString("Debug is off.", 10, 220);
        if (test.getState())
            g.drawString("Testing is on.", 10, 240);
        else
            g.drawString("Testing is off.", 10, 240);
    }
}
class MyWindowAdapter1 extends WindowAdapter {
    MenuFrame1 menuFrame;
    public MyWindowAdapter1(MenuFrame1 menuFrame) {
        this.menuFrame=menuFrame;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        menuFrame.dispose();
    }
}

class MyMenuHandler1 implements ActionListener,ItemListener {
    MenuFrame1 menuFrame;
    public MyMenuHandler1(MenuFrame1 menuFrame) {
        this.menuFrame=menuFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg="You selected ";
        String arg=e.getActionCommand();
        if (arg.equals("New...")){
            msg+="New.";
            SampleDialog d=new SampleDialog(menuFrame,"New Dialog Box");
            d.setVisible(true);
        }
        else if (arg.equals("Open..."))
            msg+="Open.";
        else if (arg.equals("Close..."))
            msg+="Close.";
        else if (arg.equals("Quit..."))
            msg+="Quit.";
        else if (arg.equals("Edit"))
            msg+="Edit.";
        else if (arg.equals("Cut"))
            msg+="Cut.";
        else if (arg.equals("Copy"))
            msg+="Copy.";
        else if (arg.equals("Paste"))
            msg+="Paste.";
        else if (arg.equals("First"))
            msg+="First.";
        else if (arg.equals("Second"))
            msg+="Second.";
        else if (arg.equals("Third"))
            msg+="Third.";
        else if (arg.equals("Debug"))
            msg+="Debug.";
        else if (arg.equals("Testing"))
            msg+="Testing.";

        menuFrame.msg=msg;
        menuFrame.repaint();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        menuFrame.repaint();
    }
}


public class DialogDemo extends Applet {
    Frame frame;

    @Override
    public void init() {
        frame=new MenuFrame1("Menu Demo");
        setSize(new Dimension(250,250));
        frame.setVisible(true);
    }

    @Override
    public void start() {
        frame.setVisible(true);
    }

    @Override
    public void stop() {
        frame.setVisible(false);
    }
}


