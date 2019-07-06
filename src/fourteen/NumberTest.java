package fourteen;

import static java.lang.Byte.decode;
import static java.lang.Float.*;
import static java.lang.Integer.toBinaryString;
import static java.lang.Integer.toOctalString;

public class NumberTest {
    public static void main (String args[]) {
        Float f = new Float(3.324324);
        Integer i = new Integer(3);
        String s = new String("5.322323");
        int a = f.intValue();
        System.out.println(a);
        Float f1=new Float(2.45646);
        System.out.println(f1);
        Float f2=new Float(NaN);
        System.out.println(f2);
        Float f3=new Float(MIN_VALUE);
        System.out.println(f3);
        byte b=f.byteValue();
        System.out.println(b);
        int c=f.compareTo(f1);
        System.out.println(c);
        boolean aa=f.equals(f1);
        System.out.println(aa);
        System.out.println(f.floatValue());
        System.out.println(f2.isNaN());
        System.out.println(isNaN(3443));
        System.out.println(parseFloat("6.434"));
        System.out.println(valueOf("3.11"));
        System.out.println(f1.hashCode());
        Double d=new Double(34232E-6);
        System.out.println(d);
        System.out.println(toHexString(i));
        System.out.println(toBinaryString(i));
        System.out.println(toOctalString(i));
    }
}

