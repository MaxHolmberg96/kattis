import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] chars = new int[4];
        int smallest = 0;
        for(int i = 0; i < chars.length; i++){
            chars[i] = scan.nextInt();
        }
        Arrays.sort(chars);
        System.out.println(chars[0] * chars[2]);

    }
}
