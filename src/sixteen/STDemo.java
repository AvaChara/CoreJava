package sixteen;

import java.util.StringTokenizer;

public class STDemo {
    static String in="title=Java: The Complete Reference;"+"author=Schildt;"+
            "publisher=Osborne/McGraw-Hill;"+"copyright=2001";
    public static void main(String args[]){
        StringTokenizer st=new StringTokenizer(in,"=;");
        while (st.hasMoreTokens()){
            String key=st.nextToken();
            System.out.println(key);
            String val=st.nextToken();
            System.out.println(val);
            System.out.println(key+"\t"+val);
        }
    }
}
