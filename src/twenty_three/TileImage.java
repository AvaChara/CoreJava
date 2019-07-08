package twenty_three;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.net.MalformedURLException;

public class TileImage extends Applet {
    Image image;
    Image cell[]=new Image[4*4];
    int iw,ih;
    int tw,th;
    File file=new File("/Users/vampire/Desktop/CoreJava/src/twenty_three/");


    @Override
    public void init() {
        setSize(288,399);
        try {
            image=getImage(file.toURI().toURL(),"timg.jpeg");
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
        tw=iw/4;
        th=ih/4;
        CropImageFilter f;
        FilteredImageSource fis;
        t=new MediaTracker(this);
        for (int y = 0; y <4 ; y++) {
            for (int x = 0; x <4 ; x++) {
                f=new CropImageFilter(tw*x,th*y,tw,th);
                fis=new FilteredImageSource(image.getSource(),f);
                int i=y*4+x;
                cell[i]=createImage(fis);
                t.addImage(cell[i],i);
            }
        }
        try {
            t.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <32 ; i++) {
            int si= (int) (Math.random()*16);
            int di= (int) (Math.random()*16);
            Image tmp=cell[si];
            cell[si]=cell[di];
            cell[di]=tmp;
        }

    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        for (int y = 0; y <4 ; y++) {
            for (int x = 0; x <4 ; x++) {
                g.drawImage(cell[y*4+x],x*tw,y*th,null);
            }
        }
    }
}
