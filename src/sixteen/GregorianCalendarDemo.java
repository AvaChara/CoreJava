package sixteen;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarDemo {
    public static void main(String args[]){
        String months[]={"Jan","Feb","mar","Apr","May",
                "Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        int year;
        GregorianCalendar gregorianCalendar=new GregorianCalendar();
        System.out.printf("Date:");
        System.out.print(months[gregorianCalendar.get(Calendar.MONTH)]);
        System.out.printf(" "+gregorianCalendar.get(Calendar.DATE)+" ");
        System.out.println(year=gregorianCalendar.get(Calendar.YEAR));

        System.out.print("Time:");
        System.out.print(gregorianCalendar.get(Calendar.HOUR));
        System.out.printf(":"+gregorianCalendar.get(Calendar.MINUTE)+":");
        System.out.println(gregorianCalendar.get(Calendar.SECOND));

        if (gregorianCalendar.isLeapYear(year)){
            System.out.println("leap year");
        }else
            System.out.println("not a leap year");
    }
}
