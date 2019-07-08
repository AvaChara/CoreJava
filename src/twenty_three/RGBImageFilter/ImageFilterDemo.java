package twenty_three.RGBImageFilter;//package twenty_three.RGBImageFilter;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.StringTokenizer;

public class ImageFilterDemo extends Applet implements ActionListener{
    Image image;
    PlugInFilter pif;
    Image fimg;
    Image curImg;
    LoadedImage lim;
    Label lab;
    Button reset;

    String s="Grayscale+Invert+Contrast+Blur+Sharpen";
    File file=new File("/Users/vampire/Desktop/CoreJava/src/twenty_three/");

    @Override
    public void init() {
        setSize(350,450);
        setLayout(new BorderLayout());
        Panel p=new Panel();
        add(p,BorderLayout.SOUTH);
        reset=new Button("Reset");
        reset.addActionListener(this);
        p.add(reset);
        StringTokenizer st=new StringTokenizer(s,"+");
        while (st.hasMoreTokens()){
            Button b=new Button(st.nextToken());
            b.addActionListener(this);
            p.add(b);
        }
        lab=new Label("");
        add(lab,BorderLayout.NORTH);

        try {
            image=getImage(file.toURI().toURL(),"timg-6.jpeg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        lim=new LoadedImage(image);
        add(lim,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a="";
        try {
            a=e.getActionCommand();
            if (a.equals("Reset")){
                lim.set(image);
                lab.setText("Normal");
            }
            else {
                a="twenty_three.RGBImageFilter."+a;
                pif= (PlugInFilter)Class.forName(a).newInstance();
                fimg=pif.filter(this,image);
                lim.set(fimg);
                lab.setText("Filtered: "+a);
            }
            repaint();
        }catch (ClassNotFoundException ae){
            lab.setText(a+ " not found");
            lim.set(image);
            repaint();
        }catch (InstantiationException ae){
            lab.setText("couldn't new  "+a);
        }catch (IllegalAccessException ae){
            lab.setText("no access: "+a);
        }
    }
}
