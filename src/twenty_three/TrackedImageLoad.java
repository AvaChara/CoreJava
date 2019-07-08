package twenty_three;

import java.applet.Applet;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.StringTokenizer;

public class TrackedImageLoad extends Applet implements Runnable {
    MediaTracker tracker;
    int tracked;
    int frame_rate = 5;
    int current_img = 0;
    Thread motor;
    static final int MAXIMAGES = 10;
    Image img[] = new Image[MAXIMAGES];
    String name[] = new String[MAXIMAGES];
    boolean stopFlag;
    String file = "timg+timg-1+timg-2+timg-3+timg-4+timg-5+timg-6";
    File path = new File("/Users/vampire/Desktop/CoreJava/src/twenty_three/");


    @Override
    public void init() {
        tracker = new MediaTracker(this);
        StringTokenizer st = new StringTokenizer(file, "+");
        while (st.hasMoreTokens() && tracked <= MAXIMAGES) {
            name[tracked] = st.nextToken();
            try {
                img[tracked] = getImage(path.toURI().toURL(), name[tracked] + ".jpeg");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            tracker.addImage(img[tracked], tracked);
            tracked++;
        }
    }

    @Override
    public void paint(Graphics g) {
        String loaded = "";
        int donecount = 0;
        for (int i = 0; i < tracked; i++) {
            if (tracker.checkID(i, true)) {
                donecount++;
                loaded += name[i] + " ";
            }
        }
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;

        if (donecount == tracked) {
            frame_rate = 1;
            Image i = img[current_img++];
            int iw = i.getWidth(null);
            int ih = i.getHeight(null);
            g.drawImage(i, (w - iw) / 2, (h - ih) / 2, null);
            if (current_img >= tracked)
                current_img = 0;
        } else {
            int x = w * donecount / tracked;
            g.setColor(Color.black);
            g.fillRect(0, h / 3, x, 16);
            g.setColor(Color.white);
            g.fillRect(x, h / 3, w - x, 16);
            g.setColor(Color.black);
            g.drawString(loaded, 10, h / 2);
        }
    }

    @Override
    public void start() {
        motor = new Thread(this);
        stopFlag = false;
        motor.start();
    }

    @Override
    public void stop() {
        stopFlag = true;
    }

    @Override
    public void run(){
        motor.setPriority(Thread.MIN_PRIORITY);
        while (true){
            repaint();
            try {
                Thread.sleep(1000/frame_rate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (stopFlag)
                return;
        }
    }
}
