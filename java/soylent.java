
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int i = 0; i < testCases; i++){
            double calories = (double)scan.nextInt();
            System.out.println((int)Math.ceil(calories/400));
        }
    }
}
