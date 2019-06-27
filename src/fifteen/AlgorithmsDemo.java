package fifteen;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class AlgorithmsDemo {
    public static void main(String args[]){
        LinkedList linkedList=new LinkedList();
        linkedList.add(new Integer(-8));
        linkedList.add(new Integer(20));
        linkedList.add(new Integer(-20));
        linkedList.add(new Integer(8));

        Comparator r= Collections.reverseOrder();
        Collections.sort(linkedList,r);

        Iterator li=linkedList.iterator();
        System.out.print("List sorted in reverse:");
        while (li.hasNext()){
            System.out.print(li.next()+" ");
        }
        System.out.println();
        Collections.shuffle(linkedList);
        li=linkedList.iterator();
        System.out.printf("List shffled");
        while (li.hasNext())
            System.out.print(li.next()+" ");
        System.out.println();

        System.out.println("Minimum : "+Collections.min(linkedList));
        System.out.println("Maximum: "+Collections.max(linkedList));
    }
}
