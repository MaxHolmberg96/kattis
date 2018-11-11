import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        int add = 0;
        for(int i = 0; i < cases; i++){
            int integer = scan.nextInt();
            int divide = integer / 10;
            add = add + (int)Math.pow(divide, integer % 10);

        }
        System.out.println(add);
    }
}
