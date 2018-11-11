import java.util.Scanner;
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int MBperMonth = scan.nextInt();
        int months = scan.nextInt();
        int totalLeft = 0;
        for(int i = 0; i < months; i++)
            totalLeft += MBperMonth - scan.nextInt();
        System.out.println(totalLeft+MBperMonth);
    }
}