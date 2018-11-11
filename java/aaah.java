
import java.util.*;


/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String jon = scan.nextLine();
        String doctor = scan.nextLine();
        if(jon.compareTo(doctor) < 1)
            System.out.println("go");
        else
            System.out.println("no");
    }
}
