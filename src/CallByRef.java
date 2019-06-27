class Test1{
    int a,b;
    Test1(int i,int j){
        a=i;
        b=j;
    }
    void meth(Test1 o){
        o.a*=2;
        o.b/=2;
    }
}
public class CallByRef {
    public static void main(String args[]){
        Test1 ob=new Test1(15,20);
        System.out.println("ob.a and ob.b before call: "+ob.a+" "+ob.b);
        ob.meth(ob);
        System.out.println("ob.a and ob.b after call: "+ob.a+" "+ob.b);
    }
}
