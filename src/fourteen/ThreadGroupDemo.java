package fourteen;

class NewThread5 extends Thread{
    boolean suspendFlag;
    NewThread5 (String threadName,ThreadGroup tgOb){
        super(tgOb,threadName);
        System.out.println("New thread:"+this);
        suspendFlag=false;
        start();
    }

    @Override
    public void run() {
        try {
            for (int i=5;i>0;i--){
                System.out.println(getName()+":"+i);
                Thread.sleep(1000);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Exception in "+getName());
        }
        System.out.println(getName()+" exiting");
    }
    void mysuspend(){
        suspendFlag=true;
    }

    synchronized void myresume(){
        suspendFlag=false;
        notify();
    }

}



public class ThreadGroupDemo {
    public static void main(String args[]){
        ThreadGroup groupA=new ThreadGroup("GroupA");
        ThreadGroup groupB=new ThreadGroup("GroupB");

        NewThread5 ob1=new NewThread5("One",groupA);
        NewThread5 ob2=new NewThread5("Two",groupA);
        NewThread5 ob3=new NewThread5("Three",groupB);
        NewThread5 ob4=new NewThread5("Four",groupB);

        System.out.println("\nHere is output from list():");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("Suspending Group A");
        Thread tga[]=new Thread[groupA.activeCount()];
        groupA.enumerate(tga);
        for (int i=0;i<tga.length;i++){
            ((NewThread5)tga[i]).mysuspend();
        }
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Resuming Group A");
        for (int i=0;i<tga.length;i++){
            ((NewThread5)tga[i]).myresume();
        }

        try {
            System.out.println("Waiting for threads to finish");
            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();
        }catch (Exception e){
            System.out.println("Exception in Main thread");
        }
        System.out.println("Main thread exiting");
    }
}
