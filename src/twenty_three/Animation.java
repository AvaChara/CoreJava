package twenty_three;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.net.MalformedURLException;
import java.util.StringTokenizer;

public class Animation extends Applet implements Runnable{
    Image cell[];
    final int MAXSEQ=64;
    String string="0,1,2,3,4,5,6,7,8,9,10";
    int sequence[];
    int nseq;
    int idx;
    int framerate=15;
    int rows=3;
    int cols=4;
    boolean stopFlag;
    File file=new File("/Users/vampire/Desktop/CoreJava/src/twenty_three/");

    private int intDef(String s,int def){
        int n=def;
        if (s!=null)
            try {
                n=Integer.parseInt(s);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        return n;
    }

    @Override
    public void init() {
        int tilex=cols;
        int tiley=rows;
        cell=new Image[tilex*tiley];

        StringTokenizer st=new StringTokenizer(string,",");
        sequence=new int[MAXSEQ];
        nseq=0;
        while (st.hasMoreTokens()&&nseq<MAXSEQ){
            sequence[nseq]=intDef(st.nextToken(),0);
            nseq++;
        }

        try {
            Image image=getImage(file.toURI().toURL(),"1.gif");
            MediaTracker t=new MediaTracker(this);
            t.addImage(image,0);
            t.waitForID(0);
            int iw=image.getWidth(null);
            int ih=image.getHeight(null);
            int tw=iw/tilex;
            int th=ih/tiley;
            CropImageFilter f;
            FilteredImageSource fis;
            for (int y = 0; y <tiley ; y++) {
                for (int x = 0; x <tilex; x++) {
                    f=new CropImageFilter(tw*x,th*y,tw,th);
                    fis=new FilteredImageSource(image.getSource(),f);
                    int i=y*tilex+x;
                    cell[i]=createImage(fis);
                    t.addImage(cell[i],i);
                }
            }
            t.waitForAll();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Graphics g) {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(cell[sequence[idx]],0,0,null);
    }

    Thread t;

    @Override
    public void start() {
        t=new Thread(this);
        stopFlag=false;
        t.start();
    }

    @Override
    public void stop() {
        stopFlag=true;
    }

    @Override
    public void run() {
        idx=0;
        while (true){
            paint(getGraphics());
            idx=(idx+1)%nseq;
            try {
                Thread.sleep(1000/framerate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            };
            if (stopFlag)
                return;
        }
    }
}
