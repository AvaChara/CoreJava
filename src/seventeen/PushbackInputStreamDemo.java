package seventeen;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushbackInputStreamDemo {
    public static void main(String args[]) throws IOException {
        String s="if(a==4) a=0;\n";
        byte buf[]=s.getBytes();
        ByteArrayInputStream in=new ByteArrayInputStream(buf);
        PushbackInputStream f=new PushbackInputStream(in);
        int c;
        while ((c=f.read())!=-1){
            switch (c){
                case '=':
                    if ((c=f.read())=='='){
                        System.out.printf(".eq.");
                    }else {
                        System.out.printf("<-");
                        f.unread(c);
                    }
                    break;
                default:
                    System.out.printf(String.valueOf((char)c));
                    break;
            }
        }
    }
}
