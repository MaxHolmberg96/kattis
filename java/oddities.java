import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++){
            int value = scan.nextInt();
            if(value % 2 == 0)
                System.out.println(value + " is even");
            else
                System.out.println(value + " is odd");
        }
    }
}
