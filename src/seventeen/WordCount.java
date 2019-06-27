package seventeen;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCount {
    public  static int words=0;
    public  static int lines=0;
    public  static int chars=0;

    public  static void wc(InputStreamReader isr) throws IOException {
        int c=0;
        boolean lastwhite=true;
        String whiteSpace=" \t\n\r";
        while ((c=isr.read())!=-1){
            chars++;
            if (c=='\n'){
                lines++;
            }
            int index=whiteSpace.indexOf(c);
            if (index==-1){
                if (lastwhite==true){
                    ++words;
                }
                lastwhite=false;
            }else {
                lastwhite=true;
            }
        }
        if (chars!=0){
            ++lines;
        }
    }
    public  static void main(String args[]){
        FileReader fileReader;
        try {
            if (args.length==0){
                wc(new InputStreamReader(System.in));
            }
            else {
                for (int i = 0; i <args.length ; i++) {
                    fileReader=new FileReader(args[i]);
                    wc(fileReader);
                }
            }
        }catch (IOException e){
            return;
        }
        System.out.println(lines+" "+words+" "+chars);
    }
}
