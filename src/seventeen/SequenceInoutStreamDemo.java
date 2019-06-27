package seventeen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumerator implements Enumeration{
    private Enumeration files;
    public InputStreamEnumerator(Vector files){
        this.files=files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public Object nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        }catch (Exception e){
            return null;
        }
    }
}
public class SequenceInoutStreamDemo {
    public static void main(String args[]) throws IOException {
        int c;
        Vector files=new Vector();
        files.addElement("/Users/vampire/Desktop/CoreJava/src/seventeen/PushbackInputStreamDemo.java");
        files.addElement("/Users/vampire/Desktop/CoreJava/src/seventeen/FileInputStreamDemo.java");
        InputStreamEnumerator e =new InputStreamEnumerator(files);
        InputStream inputStream=new SequenceInputStream(e);

        while ((c=inputStream.read())!=-1){
            System.out.printf(String.valueOf((char)c));
        }
        inputStream.close();
    }
}
