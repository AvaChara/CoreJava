package twenty_three;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.net.MalformedURLException;

public class HistoGrab extends Applet {
    Dimension d;
    Image image;
    int iw,ih;
    int pixels[];
    int w,h;
    int hist[]=new int[256];
    int max_hist;
    File file=new File("/Users/vampire/Desktop/CoreJava/src/twenty_three/");


    @Override
    public void init() {
        d=getSize();
        w=d.width;
        h=d.height;
        try {
            image=getImage(file.toURI().toURL(),"timg-2.jpeg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        MediaTracker t=new MediaTracker(this);
        t.addImage(image,0);
        try {
            t.waitForID(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iw=image.getWidth(null);
        ih=image.getHeight(null);
        pixels=new int[iw*ih];
        PixelGrabber pg=new PixelGrabber(image,0,0,iw,ih,pixels,0,iw);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <iw*ih ; i++) {
            int p=pixels[i];
            int r=0xff&(p>>16);
            int g=0xff&(p>>8);
            int b=0xff&(p);
            int y=(int)(.33*r+.56*g+.11*b);
            hist[y]++;
        }
        for (int i = 0; i <256 ; i++) {
            if (hist[i]>max_hist)
                max_hist=hist[i];
        }
    }

    @Override
    public void update(Graphics g) {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image,0,0,this);
        int x=(w-256)/2;
        int lasty=h-h*hist[0]/max_hist;
        for (int i = 0; i <256 ; i++,x++) {
            int y=h-h*hist[i]/max_hist;
            g.setColor(new Color(i,i,i));
            g.fillRect(x,y,1,h);
            g.setColor(Color.red);
            g.drawLine(x-1,lasty,x,y);
            lasty=y;
        }
    }
}
