package twenty_six;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JCheckBoxDemo extends JApplet implements ItemListener {
    JTextField jtf;
    private final static int WIDTH=250;
    private final static int HEIGHT=150;
    @Override
    public void init() {
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        ImageIcon normal=new ImageIcon("/Users/vampire/Desktop/CoreJava/src/twenty_six/timg-1.jpeg");
        ImageIcon rollover=new ImageIcon("/Users/vampire/Desktop/CoreJava/src/twenty_six/timg-2.jpeg");
        ImageIcon selected=new ImageIcon("/Users/vampire/Desktop/CoreJava/src/twenty_six/timg-3.jpeg");
        normal.setImage(normal.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_DEFAULT));
        rollover.setImage(rollover.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_DEFAULT));
        selected.setImage(selected.getImage().getScaledInstance(WIDTH,HEIGHT,Image.SCALE_DEFAULT));

        JCheckBox cb;

        cb=new JCheckBox("C",normal);
        cb.setRolloverIcon(rollover);
        cb.setSelectedIcon(selected);
        cb.addItemListener(this);
        container.add(cb);

        cb=new JCheckBox("C++",normal);
        cb.setRolloverIcon(rollover);
        cb.setSelectedIcon(selected);
        cb.addItemListener(this);
        container.add(cb);

        cb=new JCheckBox("Java",normal);
        cb.setRolloverIcon(rollover);
        cb.setSelectedIcon(selected);
        cb.addItemListener(this);
        container.add(cb);

        cb=new JCheckBox("Perl",normal);
        cb.setRolloverIcon(rollover);
        cb.setSelectedIcon(selected);
        cb.addItemListener(this);
        container.add(cb);

        jtf=new JTextField(15);
        container.add(jtf);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox cb= (JCheckBox) e.getItem();
        jtf.setText(cb.getText());
    }
}
