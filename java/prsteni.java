import java.util.Scanner;

public class Prsteni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] rings = new int[n];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < rings.length; i++) {
            rings[i] = Integer.parseInt(s[i]);
        }
        for (int i = 1; i < rings.length; i++) {
            long numerator = rings[0];
            long denominator = rings[i];
            for (long j = denominator; j >= 1; j--) {
                if(numerator % j == 0 && denominator % j == 0){
                    numerator /= j;
                    denominator /= j;
                    break;
                }
            }
            System.out.println(numerator + "/" + denominator);
        }
    }
}
