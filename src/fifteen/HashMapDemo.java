package fifteen;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String args[]){
        HashMap hm=new HashMap();
        hm.put("q",new Double(3434.23));
        hm.put("w",new Double(123.23));
        hm.put("r",new Double(1235.32));
        hm.put("e",new Double(77.43));
        hm.put("t",new Double(-123.53));

        Set set=hm.entrySet();

        Iterator i=set.iterator();

        while (i.hasNext()){
            Map.Entry me=(Map.Entry) i.next();
            System.out.print(me.getKey()+": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        double balance=((Double)hm.get("q")).doubleValue();
        hm.put("q",new Double(balance+1000));
        System.out.println("q's new balance:"+hm.get("q"));
    }
}
