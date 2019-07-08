package twenty_three;

import java.applet.Applet;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;

public class ObservedImageLoad extends Applet {
    Image image;
    boolean error=false;
    String imgname;

    @Override
    public void init() {
        setBackground(Color.blue);
        File file=new File("/Users/vampire/Desktop/CoreJava/src/twenty_three/background.jpeg");
        try {
            image=getImage(file.toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (error){
            Dimension d=getSize();
            g.setColor(Color.red);
            g.fillRect(0,0,d.width,d.height);
            g.setColor(Color.black);
            g.drawString("Image not found: "+imgname,10,d.height/2);
        }else {
            g.drawImage(image,0,0,this);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int w, int h) {
        if ((infoflags&SOMEBITS)!=0){
            repaint(x,y,w,h);
        }else if ((infoflags&ABORT)!=0){
            error=true;
            repaint();
        }
        return (infoflags&(ALLBITS|ABORT))==0;
    }
}
