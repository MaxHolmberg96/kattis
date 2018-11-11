import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long one = 0;
        long two = 0;
        while(scan.hasNextLong()){
            one = scan.nextLong();
            two = scan.nextLong();
            if(one > two)
                System.out.println(one - two);
            else
                System.out.println(two - one);
            scan.nextLine();
        }
    }
}
