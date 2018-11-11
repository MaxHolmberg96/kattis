import java.util.Scanner;
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int x = scan.nextInt();
        System.out.println((int)Math.ceil(h / Math.sin(Math.toRadians(x))));
    }
}