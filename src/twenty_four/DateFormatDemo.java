package twenty_four;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatDemo {
    public static void main(String args[]){
        Date date=new Date();
        DateFormat df;
        df=DateFormat.getDateInstance(DateFormat.SHORT, Locale.JAPAN);
        System.out.println("Japan: "+df.format(date));

        df=DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.UK);
        System.out.println("United Kingdom: "+df.format(date));

        df=DateFormat.getDateInstance(DateFormat.LONG,Locale.KOREA);
        System.out.println("Korea: "+df.format(date));

        df=DateFormat.getDateInstance(DateFormat.FULL,Locale.US);
        System.out.println("United State: "+df.format(date));
    }
}
