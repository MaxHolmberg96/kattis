import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int day = scan.nextInt();
        int month = scan.nextInt();
        Calendar year = new GregorianCalendar(2009, month-1, day);
        System.out.println(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(year.getTime().getTime()));
    }
}
