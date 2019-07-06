package fourteen;

//实现Runnable接口创建线程
class NewThread implements Runnable{
    Thread thread;
    NewThread(){
        thread=new Thread(this,"Demo Thread");
        System.out.println("Child thread:"+thread);
        thread.start();
    }
    public void run(){
        try {
            for (int i=5;i>0;i--){
                System.out.println("Child Thread:"+i);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}
public class ThreadDemo {
    public static void main(String args[]){
        new NewThread();
        try {
            for (int i=5;i>0;i--){
                System.out.println("Main Thread:"+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}
