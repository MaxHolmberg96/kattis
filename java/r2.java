import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int in = scan.nextInt();
        int answer = scan.nextInt();
        int big = answer * 2;
        int out = big - in;
        System.out.println(out);
    }
}
