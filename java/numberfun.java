import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int i = 0; i < c; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = sc.nextInt();
            if(a*b == r){
                System.out.println("Possible");
            }
            else if(a+b == r){
                System.out.println("Possible");
            }
            else if(a-b == r){
                System.out.println("Possible");
            }
            else if(b-a == r){
                System.out.println("Possible");
            }
            else if(a/b == r && a%b == 0){
                System.out.println("Possible");
            }
            else if(b/a == r && b%a == 0){
                System.out.println("Possible");
            }
            else{
                System.out.println("Impossible");
            }
        }
    }
}