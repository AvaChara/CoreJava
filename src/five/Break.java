package five;

public class Break {
    public static void main(String args[]) {
        boolean t=true;
        first:{
            second:{
                third:{
                    System.out.println("Before the break.");
                    if (t) break second;//break out of two break
                    System.out.println("This three");
                }
                System.out.println("This two");
            }
            System.out.println("This one");
        }
        System.out.println("This main");
    }
}