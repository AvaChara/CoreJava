import java.util.ArrayList;

public class ArrayListToArray {
    public static void main(String args[]){
        ArrayList arrayList=new ArrayList();
        arrayList.add(new Integer(1));
        arrayList.add(new Integer(2));
        arrayList.add(new Integer(3));
        arrayList.add(new Integer(4));

        System.out.println("contents of arraylist:"+arrayList);

        Object ia[]=arrayList.toArray();
        int sum=0;
        for (int i=0;i<ia.length;i++){
            System.out.println(ia[i]);
        }
    }
}
