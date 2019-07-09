package twenty_six;

import javax.swing.*;
import java.awt.*;

public class JTextFieldDemo extends JApplet {
    JTextField jtf;

    @Override
    public void init() {
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        jtf=new JTextField(15);
        container.add(jtf);
    }
}
