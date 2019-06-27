package seventeen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamDemo {
    public static void main(String args[]) throws IOException {
        int size;
        InputStream inputStream=new FileInputStream("/Users/vampire/Desktop/CoreJava/src/seventeen/FileInputStreamDemo.java");
        System.out.println("Total Available bytes: " + (size = inputStream.available()));
        int n=size/40;
        System.out.println("First " + n + " bytes of the file one read() at a time");
        for (int i = 0; i < n; i++) {
            System.out.println((char) inputStream.read());
        }
        System.out.println("\nStill Avaliable :"+inputStream.available());
        System.out.println("Reading the next "+n+" with one read(b[])");
        byte b[]=new  byte[n];
        if (inputStream.read(b)!=n){
            System.err.println("couldn't read "+n+" bytes");
        }
        System.out.println(new String(b,0,n));
        System.out.println("\nStill Avaliable :"+(size=inputStream.available()));
        System.out.println("Skipping half of remaining bytes with skip()");
        inputStream.skip(size/2);
        System.out.println("Still Available: "+inputStream.available());
        System.out.println("Reading "+n/2+" into the end of array");
        if (inputStream.read(b,n/2,n/2)!=n/2){
            System.out.println("couldn't read "+n/2+" bytes.");
        }
        System.out.println(new String(b,0,b.length));
        System.out.println("\n Still Avaliable : "+ inputStream.available());
    }
}
