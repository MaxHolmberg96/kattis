import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        System.out.printf("%.6f \n %.6f\n", Math.PI*Math.pow(r,2), 2*Math.pow(r,2));
    }
}