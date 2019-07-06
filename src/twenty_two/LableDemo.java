package twenty_two;

import java.applet.Applet;
import java.awt.*;

public class LableDemo extends Applet{
    @Override
    public void init() {
        Label one=new Label("One");
        Label two=new Label("two");
        Label three=new Label("three", Label.LEFT);
        add(three);
        add(one);
        add(two);


    }
}
