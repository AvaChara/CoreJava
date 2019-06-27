class Test{

    void math(int i, int j){
        i*=2;
        j/=2;
    }
    String math2(int i,int j){
        i*=2;
        j/=2;
        return i+" "+j;
    }
}
public class CallByValue {
    public static void main(String args[]){
        Test ob=new Test();
        int a=20;
        int b=15;
        System.out.println("a and b before call math: "+a+" "+b);
        ob.math(a,b);
        System.out.println("a and b after call math: "+a+" "+b);
        String str=ob.math2(a,b);
        System.out.println("a and b after call math2: "+str);
    }
}
