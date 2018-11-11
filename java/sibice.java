import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[3];
        arr[0] = scan.nextInt();
        arr[1] = scan.nextInt();
        arr[2] = scan.nextInt();
        for (int i = 0; i < arr[0]; i++) {
            if(scan.nextInt() <= Math.sqrt(Math.pow(arr[1], 2) + Math.pow(arr[2], 2)))
                System.out.println("DA");
            else
                System.out.println("NE");
        }
    }
}








