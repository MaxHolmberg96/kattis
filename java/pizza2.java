import java.io.*;
import java.util.*;

public class main {


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int R = scan.nextInt();
        int C = scan.nextInt();
        System.out.printf("%.6f", ((( Math.PI*Math.pow(R - C, 2))/ (Math.PI*Math.pow(R, 2)))* 100));
    }
}