package twenty_three;

import java.applet.Applet;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class SimpleImageLoad extends Applet {
    Image image;

    File file=new File("/Users/vampire/Desktop/CoreJava/src/twenty_three/background.jpeg");
    @Override
    public void init() {
        try {
            image=getImage(file.toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image,0,0,300,200,this);
    }
}
