import java.util.HashSet;
import java.util.Scanner;
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashSet<Integer> r = new HashSet<>();
        for(int i = 0; i < 10; i++){
            r.add(scan.nextInt() % 42);
        }
        System.out.println(r.size());
    }
}