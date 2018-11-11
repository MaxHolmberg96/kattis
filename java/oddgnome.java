import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int nr = sc.nextInt();
        label:
        for (int i = 0; i < nr; i++) {
            boolean found = false;
            int nr_g = sc.nextInt();
            int[] a = new int[nr_g];
            for (int j = 0; j < nr_g; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < a.length-2; j++) {
                if(a[j] < a[j+1] && a[j+2] < a[j+1] && a[j+2] > a[j] && !found){
                    System.out.println(j+2);
                    found = true;
                }
                else if(a[j] > a[j+1] && a[j+2] > a[j+1] && a[j+2] > a[j] && !found){
                    System.out.println(j+2);
                    found = true;
                }
            }
        }
    }

}