package twenty_six;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JComboBoxDemo extends JApplet implements ItemListener{
    JLabel jl;
    ImageIcon timg_1,timg_2,timg_3,timg_4;

    @Override
    public void init() {
        Container container=getContentPane();
        container.setLayout(new FlowLayout());

        JComboBox jc=new JComboBox();
        jc.addItem("timg-1");
        jc.addItem("timg-2");
        jc.addItem("timg-3");
        jc.addItem("timg-4");
        jc.addItemListener(this);
        container.add(jc);

        jl=new JLabel(new ImageIcon("/Users/vampire/Desktop/CoreJava/src/twenty_six/timg.jpeg"));
        container.add(jl);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String s= (String) e.getItem();
        jl.setIcon(new ImageIcon("/Users/vampire/Desktop/CoreJava/src/twenty_six/"+s+".jpeg"));
    }
}
