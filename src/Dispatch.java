import static javax.print.attribute.standard.MediaSizeName.C;

class TestA{
    void callme(){
        System.out.println("Inside A's callme method");
    }
}
class TestB extends TestA{
    void callme(){
        System.out.println("Inside B's callme method");
    }
}
class TestC extends TestB{
    void callme(){
        System.out.println("Inside C's callme method");
    }
}
public class Dispatch {
    public static void main(String args[]){
        TestA a= new TestA();
        TestB b=new TestB();
        TestC c=new TestC();
        TestA r;

        r=a;
        r.callme();
        r=b;
        r.callme();
        r=c;
        r.callme();
    }
}
