import java.util.*;


/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < cases; i++){
            int length = scan.nextLine().length();
            System.out.println(length);
        }
    }
}
