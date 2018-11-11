import java.util.HashSet;
import java.util.Scanner;

public class nodup {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String[] s = new Scanner(System.in).nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            if(set.contains(s[i])){
                System.out.println("no");
                break;
            } else {
                set.add(s[i]);
            }
            if(i == s.length-1){
                System.out.println("yes");
            }
        }
    }
}
