class NewThread3 implements Runnable{
    String name;
    Thread thread;

    NewThread3(String threadname){
        name=threadname;
        thread=new Thread(this,name);
        System.out.println("New Thread: "+thread);
        thread.start();
    }
    public void run(){
        try {
            for (int i=5;i>0;i--){
                System.out.println(name+": "+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println(name+" Interrupted");
        }
        System.out.println(name+" exiting");
    }
}
public class MultiThreadDemo {
    public static void main(String args[]){
        new NewThread3("One");
        new NewThread3("Two");
        new NewThread3("Three");
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");

    }
}
