import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int nr_tasks = sc.nextInt(), tot = sc.nextInt(), sum = 0, i;
        for (i = 0; i < nr_tasks; i++) {
            int tmp = sc.nextInt();
            if(sum + tmp > tot){
                break;
            }
            else{
                sum += tmp;
            }
        }
        System.out.println(i);
    }

}