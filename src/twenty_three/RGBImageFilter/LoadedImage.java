package twenty_three.RGBImageFilter;

import java.awt.*;

public class LoadedImage extends Canvas{
    Image image;
    public LoadedImage(Image i){
        set(i);
    }
    void set(Image i)  {
        MediaTracker mt=new MediaTracker(this);
        mt.addImage(i,0);
        try {
            mt.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        image=i;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (image==null){
            g.drawString("no image",10,30);
        }else {
            g.drawImage(image,0,0,this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(this),image.getHeight(this));
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
