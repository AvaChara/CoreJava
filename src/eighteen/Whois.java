package eighteen;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {
    public static void main(String args[]) throws IOException {
        int c;
        Socket s=new Socket("internic.net",43);
        InputStream inputStream=s.getInputStream();
        OutputStream outputStream=s.getOutputStream();
        String s1=(args.length==0 ? "baidu.com":args[0])+"\n";
        byte buf[]=s1.getBytes();
        outputStream.write(buf);
        while ((c=inputStream.read())!=-1){
            System.out.print((char)c);
        }
        s.close();
    }
}
