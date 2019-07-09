package twenty_four;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String args[]){
        Date date=new Date();
        SimpleDateFormat sdf;
        sdf=new SimpleDateFormat("hh:mm:ss");
        System.out.println(sdf.format(date));

        sdf=new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzzz");
        System.out.println(sdf.format(date));

        sdf=new SimpleDateFormat("EEEE MMMM dd yyyy");
        System.out.println(sdf.format(date));
    }
}
