package club.gongsir.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {
    public static void main(String [] args){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
    }
}
