import java.util.Scanner;

public class railroad2 {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt(new Scanner(System.in).nextLine().split(" ")[1]) % 2 == 0 ? "possible" : "impossible");
    }
}