import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.ImageObserver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DynamicBillboard extends Applet implements Runnable{
    String bgcolor="#ffffff";//背景
    long delay=5000;//延迟
    int billboard=5;//广告数

    String bill0="timg.png,http://www.baidu.com";//image，url
    String bill1="timg-1.png,http://www.juooo.com";
    String bill2="timg-2.png,https://www.csdn.net";
    String bill3="timg-3.png,https://www.douban.com";
    String bill4="timg-4.png,http://www.poly.com.cn";

    //转换类型
    String transitions="5,ColumnTransition,FadeTransition,TearTransition,SmashTransition,UnrollTransition";

//    File file=new File("/Users/vampire/Desktop/CoreJava/src/twenty_eight/");
    File file=new File("/Users/vampire/Desktop/CoreJava/src/");

    BillData[] billboards;
    int current_billboard;
    int next_billboard;

    String[] transiton_classes=null;
    Thread thread=null;
    Image image=null;
    boolean mouse_inside_applet;
    String link_target_frame;
    boolean stopFlag;

    @Override
    public void init() {
        //设置背景
        String s=bgcolor;
        if (s!=null){
            Color color=new Color(Integer.parseInt(s.substring(1),16));
            setBackground(color);
            getParent().setBackground(color);
            getParent().repaint();
        }

        billboards=new BillData[billboard];

        //随机数控制当前显示的图片
        current_billboard=next_billboard= (int) (Math.random() * billboards.length-1);//0-4随机数
        try {
            parseBillData();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    void parseBillData() throws MalformedURLException {
        String s = null;//图片信息
        if (next_billboard==0) {
             s = bill0;
        }
        else if (next_billboard==1) {
             s = bill1;
        }
        else if (next_billboard==2) {
             s = bill2;
        }
        else if (next_billboard==3) {
             s = bill3;
        }
        else if (next_billboard==4) {
             s = bill4;
        }

        System.out.println(s);

        int field_end=s.indexOf(",");
        String ss=s.substring(0,field_end);
        Image new_image=getImage(file.toURI().toURL(),ss);
        URL link;
        try {
            link=new URL(getDocumentBase(),s.substring(field_end+1));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            link=getDocumentBase();
        }

        billboards[next_billboard]=new BillData(link,new_image);
        if (image==null){
            image=new_image;
        }else {
            prepareImage(new_image,this);
            billboards[next_billboard].initPixels(getSize().width,getSize().height);
        }
    }

    void finishInit(){
        link_target_frame="right";

        String s=transitions;
        int field_end=s.indexOf(",");
        int trans_count=Integer.parseInt(s.substring(0,field_end));
        transiton_classes=new String[trans_count];
        for (--trans_count;trans_count>0;--trans_count){
            s=s.substring(field_end+1);
            field_end=s.indexOf(",");
            transiton_classes[trans_count]=s.substring(0,field_end);
        }
        transiton_classes[0]=s.substring(field_end+1);
        billboards[next_billboard].initPixels(getSize().width,getSize().height);
        mouse_inside_applet=false;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image,0,0,this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void start() {
        next_billboard=current_billboard;
        image=billboards[current_billboard].image;
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (thread==null){
            thread=new Thread(this);
            thread.start();
        }
        System.out.println("thread");
    }


    @Override
    public void stop() {
        if (thread!=null){
            stopFlag=true;
        }
    }

    @Override
    public void run() {
        while ((checkImage(image, this)& ImageObserver.ALLBITS)==0){
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
            }
        }
        finishInit();

        addMouseListener(new MyMouseAdapter());
        addMouseMotionListener(new MyMouseMotionAdapter());

        int last_transition_type=-1;
        BillTransition transition;
        long next_billboard_time;
        while (true){
            if (stopFlag)
                return;
            next_billboard_time=System.currentTimeMillis()+delay;
            current_billboard=next_billboard;
            System.out.println("current");
            if (++next_billboard>=billboards.length){
                next_billboard_time=0;
            }
            if (billboards[next_billboard]==null){
                try {
                    parseBillData();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(120);
                } catch (InterruptedException e) {
                }
            }
            int transition_type= (int) (Math.random() * (transiton_classes.length - 1));
            if (transition_type>=last_transition_type){
                ++transition_type;
            }
            last_transition_type=transition_type;
            try {
                String trans=transiton_classes[last_transition_type];
                transition=(BillTransition) Class.forName(trans).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            transition.init(this,billboards[current_billboard].image_pixels,billboards[next_billboard].image_pixels);

            if (System.currentTimeMillis()<next_billboard_time){
                try {
                    Thread.sleep(next_billboard_time-System.currentTimeMillis());
                } catch (InterruptedException e) {
                }
            }

            Graphics g=getGraphics();
            for (int c = 0; c <transition.cells.length ; ++c) {
                image = transition.cells[c];
                g.drawImage(image, 0, 0, null);
                getToolkit().sync();

                try {
                    Thread.sleep(transition.delay);
                } catch (InterruptedException e) {
                }
            }
            image=billboards[next_billboard].image;
            g.drawImage(image,0,0,null);
            getToolkit().sync();
            g.dispose();
            if (mouse_inside_applet==true){
                showStatus(billboards[next_billboard].link.toExternalForm());
            }
            transition=null;
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
            }
        }
    }

    public class MyMouseAdapter extends MouseAdapter{
        @Override
        public void mouseExited(MouseEvent e) {
            mouse_inside_applet=false;
            showStatus("");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            stop();
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            getAppletContext().showDocument(billboards[current_billboard].link,link_target_frame);
        }
    }

    public class MyMouseMotionAdapter extends MouseMotionAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
            mouse_inside_applet=true;
            showStatus(billboards[current_billboard].link.toExternalForm());
        }
    }
}
