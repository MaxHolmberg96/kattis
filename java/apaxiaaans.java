
import java.util.*;


/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        System.out.println(word.replaceAll("(.)\\1{1,}", "$1"));
    }
}