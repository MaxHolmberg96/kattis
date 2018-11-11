
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int second = scan.nextInt();
        if(second > first){
            if(second - first == 1)
                System.out.println("Dr. Chaz will have " + (second - first) + " piece of chicken left over!");
            else
                System.out.println("Dr. Chaz will have " + (second - first) + " pieces of chicken left over!");
        }
        if(second < first){
            if(first - second == 1)
                System.out.println("Dr. Chaz needs " + (first - second) + " more piece of chicken!");
            else
                System.out.println("Dr. Chaz needs " + (first - second) + " more pieces of chicken!");
        }
    }
}
