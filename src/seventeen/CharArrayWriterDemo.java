package seventeen;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterDemo {
    public static void main(String args[]) throws IOException {
        CharArrayWriter f=new CharArrayWriter();
        String s="adad uiyad uiaua dada";
        char buf[]=new char[s.length()];
        s.getChars(0,s.length(),buf,0);
        f.write(buf);
        System.out.println("Buffer as a String");
        System.out.println(f.toString());
        System.out.println("Into array");

        char c[]=f.toCharArray();
        for (int i = 0; i <c.length ; i++) {
            System.out.print(c[i]);
        }
        System.out.println("\nTo a FileWriter");
        FileWriter fileWriter=new FileWriter("test.txt");
        f.writeTo(fileWriter);
        fileWriter.close();
        System.out.println("Doing a reset");
        f.reset();
        for (int i = 0; i <3 ; i++) {
            f.write('X');
        }
        System.out.println(f.toString());
        f.reset();
        f.write("aaaàaá");
        System.out.println(f.toString());
    }
}
