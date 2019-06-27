package eighteen;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class UCDemo {
    public static void main(String args[]) throws IOException {
        int c;
        URL hp=new URL("http://www.csdn.net");
        URLConnection hpcon=hp.openConnection();
        System.out.println("Date:" + new Date(hpcon.getDate()));
        System.out.println("Content-type:" + hpcon.getContentType());
        System.out.println("Expires: " + hpcon.getExpiration());
        System.out.println("Last-Modified: " + new Date(hpcon.getLastModified()));
        int len=hpcon.getContentLength();
        System.out.println("Content-Length: "+len);
        if (len>0){
            System.out.println("====Content====");
            InputStream inputStream=hpcon.getInputStream();
            int i=len;
            while (((c = inputStream.read()) != -1) && (--i > 0)) {
                System.out.print((char)c);
            }
            inputStream.close();
        }
        else {
            System.out.println("No Content Avaliable");
        }
    }
}
