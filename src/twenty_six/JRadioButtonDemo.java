package twenty_six;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioButtonDemo extends JApplet implements ActionListener{
    JTextField jTextField;

    @Override
    public void init() {
        Container container=getContentPane();
        container.setLayout(new FlowLayout());

        JRadioButton b1=new JRadioButton("A");
        b1.addActionListener(this);
        container.add(b1);

        JRadioButton b2=new JRadioButton("B");
        b2.addActionListener(this);
        container.add(b2);

        JRadioButton b3=new JRadioButton("C");
        b3.addActionListener(this);
        container.add(b3);

        ButtonGroup bg=new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);

        jTextField=new JTextField(5);
        container.add(jTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jTextField.setText(e.getActionCommand());
    }
}
