package sixteen;

import java.util.TimeZone;

public class TimeZoneDemo {
    public static void main(String args[]){
        TimeZone timeZone=TimeZone.getDefault();
        System.out.println(timeZone);
        System.out.println(timeZone.getID());
        System.out.println(timeZone.useDaylightTime());
        System.out.println(TimeZone.getTimeZone("Asia/shanghai"));
    }
}
