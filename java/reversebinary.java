import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String binary = Integer.toBinaryString(scan.nextInt());
        System.out.println(Integer.parseInt(new StringBuilder(binary).reverse().toString(), 2));
    }
}