package eleven;

public class CurrentThreadDemo {
    public static void main(String args[]){
        Thread thread=Thread.currentThread();
        //thread输出：线程名称，优先级以及组的名称
        System.out.println("Current thread: "+thread);
        thread.setName("My thread");
        System.out.println("After name change:"+thread);
        try {
            for (int n=5;n>0;n--){
                System.out.println(n);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
    }
}
