package first;

public class argsTest {
    public static void main(String args[]){
        System.out.println(args.length);
        if (args.length!=0){
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        }else
            System.out.println("args==0");
    }
}
