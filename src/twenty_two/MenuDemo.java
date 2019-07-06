package twenty_two;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MenuDemo extends Applet{
    Frame frame;

    @Override
    public void init() {
        frame=new MenuFrame("Menu Demo");
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

class MenuFrame extends Frame {
    String msg = "";
    CheckboxMenuItem debug, test;

    MenuFrame(String title) {
        super(title);
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        Menu file = new Menu("File");

        MenuItem item, item1, item2, item3, item4;
        file.add(item = new MenuItem("New..."));
        file.add(item1 = new MenuItem("Open..."));
        file.add(item2 = new MenuItem("Close..."));
        file.add(item3 = new MenuItem("-"));
        file.add(item4 = new MenuItem("Quit..."));
        menuBar.add(file);

        Menu edit = new Menu("Edit");
        MenuItem item5, item6, item7, item8;
        edit.add(item5 = new MenuItem("Cut"));
        edit.add(item6 = new MenuItem("Copy"));
        edit.add(item7 = new MenuItem("Paste"));
        edit.add(item8 = new MenuItem("-"));

        Menu sub = new Menu("Special");
        MenuItem item9, item10, item11;
        sub.add(item9 = new MenuItem("First"));
        sub.add(item10 = new MenuItem("Second"));
        sub.add(item11 = new MenuItem("Third"));
        edit.add(sub);

        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Testing");
        edit.add(test);

        menuBar.add(edit);

        MyMenuHandler handler = new MyMenuHandler(this);
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
        item10.addActionListener(handler);
        item11.addActionListener(handler);
        debug.addItemListener(handler);
        test.addItemListener(handler);

        MyWindowAdapter adapter = new MyWindowAdapter(this);
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
     class MyMenuHandler implements ActionListener,ItemListener {
        MenuFrame menuFrame;
        public MyMenuHandler(MenuFrame menuFrame) {
            this.menuFrame=menuFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String msg="You selected ";
            String arg=e.getActionCommand();
            if (arg.equals("New..."))
                msg+="New.";
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

    class MyWindowAdapter extends WindowAdapter{
        MenuFrame menuFrame;
        public MyWindowAdapter(MenuFrame menuFrame) {
            this.menuFrame=menuFrame;
        }

        @Override
        public void windowClosing(WindowEvent e) {
            menuFrame.setVisible(false);
        }
    }
