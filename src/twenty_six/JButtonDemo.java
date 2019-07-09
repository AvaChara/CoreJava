package twenty_six;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonDemo extends JApplet implements ActionListener{
    JTextField jtf;
    private final static int WIDTH=250;
    private final static int HEIGHT=150;

    @Override
    public void init() {
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        JButton jb = null;

        ImageIcon timg=new ImageIcon("/Users/vampire/Desktop/CoreJava/src/twenty_six/timg.jpeg");
        timg.setImage(timg.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_DEFAULT));
        jb=new JButton(timg);
        jb.setActionCommand("timg");
        jb.addActionListener(this);
        container.add(jb);

        ImageIcon timg_1=new ImageIcon("/Users/vampire/Desktop/CoreJava/src/twenty_six/timg-1.jpeg");
        timg_1.setImage(timg_1.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_DEFAULT));
        jb=new JButton(timg_1);
        jb.setActionCommand("timg_1");
        jb.addActionListener(this);
        container.add(jb);

        ImageIcon timg_2=new ImageIcon("/Users/vampire/Desktop/CoreJava/src/twenty_six/timg-2.jpeg");
        timg_2.setImage(timg_2.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_DEFAULT));
        jb=new JButton(timg_2);
        jb.setActionCommand("timg_2");
        jb.addActionListener(this);
        container.add(jb);

        ImageIcon timg_3=new ImageIcon("/Users/vampire/Desktop/CoreJava/src/twenty_six/timg-3.jpeg");
        timg_3.setImage(timg_3.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_DEFAULT));
        jb=new JButton(timg_3);
        jb.setActionCommand("timg_3");
        jb.addActionListener(this);
        container.add(jb);

        jtf=new JTextField(15);
        container.add(jtf);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jtf.setText(e.getActionCommand());
    }
}
