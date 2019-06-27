package sixteen;

import java.util.Timer;
import java.util.TimerTask;

class MyTimeTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("Timer task executed");
    }
}
public class TaskTest {
    public static void main(String args[]){
        MyTimeTask myTimeTask=new MyTimeTask();
        Timer mytimer=new Timer();
        mytimer.schedule(myTimeTask,2000,1000);
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){}
            mytimer.cancel();

    }
}
