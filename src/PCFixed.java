class  Q{
    int n;
    boolean valueSet=false;

    synchronized int getN(){
        if (!valueSet)
            try {
            wait();
            }catch (InterruptedException e){
            System.out.println("InterruptedException caught");
            }
            System.out.println("Got: "+n);
            valueSet=false;
            notify();
            return n;
    }
    synchronized void setN(int n){
        if (valueSet)
            try {
            wait();
            }catch (InterruptedException e){
                System.out.println("InterruptedException caught");
            }
            this.n=n;
            valueSet=true;
            System.out.println("Put:"+n);
            notify();
    }
}

class Producer implements Runnable{
    Q q;
    Producer (Q q){
        this.q=q;
        new Thread(this,"Producer").start();
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            q.setN(i++);
        }
    }
}

class Consumer implements Runnable{
    Q q;
    Consumer(Q q ){
        this.q=q;
        new Thread(this,"Consumer").start();
    }
    public void run(){
        while (true){
            q.getN();
        }
    }
}
public class PCFixed {
    public static void main(String args[]){
        Q q=new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Control-c to stop");
    }
}
