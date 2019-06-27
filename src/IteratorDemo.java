import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String args[]){
        ArrayList arrayList=new ArrayList();
        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("E");
        arrayList.add("B");
        arrayList.add("D");
        arrayList.add("F");

        System.out.print("Original contents of arraylist:");
        Iterator iterator=arrayList.iterator();
        while (iterator.hasNext()){
            Object element=iterator.next();
            System.out.printf(element+" ");
        }
        System.out.println();

        ListIterator listIterator=arrayList.listIterator();
        while (listIterator.hasNext()){
            Object element=listIterator.next();
            listIterator.set(element+"+");
        }
        System.out.printf("Modified contents of arraylist:");
        iterator=arrayList.iterator();
        while (iterator.hasNext()){
            Object element=iterator.next();
            System.out.printf(element+" ");
        }
        System.out.println();
        System.out.printf("Modified list backwards: ");
        while (listIterator.hasPrevious()){
            Object element=listIterator.previous();
            System.out.printf(element+" ");
        }
        System.out.println();
    }
}
