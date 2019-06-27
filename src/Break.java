public class Break {
    public static void main(String args[]) {
        boolean t=true;
        first:{
            second:{
                third:{
                    System.out.println("Before the break.");
                    if (t) break second;//break out of second break
                    System.out.println("This third");
                }
                System.out.println("This second");
            }
            System.out.println("This first");
        }
        System.out.println("This main");
    }
}