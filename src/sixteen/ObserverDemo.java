package sixteen;
import java.util.*;
class Watcher implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update() called,count is "+((Integer)arg).intValue());
    }
}

class BeingWatched extends Observable{
    void count(int period){
        for (;period>=0;period--){
            setChanged();
            System.out.println("A!!!");
            notifyObservers(new Integer(period));
            System.out.println("!@#");
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println("Sleep interrupted");
            }
        }
    }
}
public class ObserverDemo {
    public  static void main(String args[]){
        BeingWatched beingWatched=new BeingWatched();
        Watcher watcher=new Watcher();

        beingWatched.addObserver(watcher);
        beingWatched.count(10);
    }
}
