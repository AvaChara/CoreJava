package twenty_six;

import javax.swing.*;
import java.awt.*;

public class JLableDemo extends JApplet {
    @Override
    public void init() {
        setSize(250,150);
        Container container=getContentPane();
        ImageIcon ii=new ImageIcon("/Users/vampire/Desktop/CoreJava/src/twenty_six/1.gif");
        JLabel jl=new JLabel("gif",ii,JLabel.CENTER);
        container.add(jl);
    }
}
