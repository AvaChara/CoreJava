package sixteen;

import java.util.Date;

public class DateDemo {
    public static void main(String args[]) {
        Date date=new Date();
        System.out.println(date);

        long msec=date.getTime();
        System.out.println(msec);

        Date date1=new Date(97,8,21);
        System.out.println(date1);

        System.out.println(date1.before(date));
    }
}