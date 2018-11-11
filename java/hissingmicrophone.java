import java.util.HashSet;
import java.util.Scanner;

public class nodup {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        int i = 0;
        for (; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1) && s.charAt(i) == 's' && s.charAt
                    (i+1) == 's'){
                System.out.println("hiss");
                break;
            }
        }
        if(i == s.length()-1){
            System.out.println("no hiss");
        }
    }
}
