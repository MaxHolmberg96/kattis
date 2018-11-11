import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    private static int articles;
    private static double factor;
    public static void main(String[] args) throws IOException {
        Scanner katt = new Scanner(System.in);
        articles = katt.nextInt();
        factor = katt.nextInt() - 0.99;
        double current;
        double previous = 1;

        double h = 1e-8;
        double error;
        int i = 0;
        double relError = 0.00001;
        while (true) {
            current = previous - func(previous) / ((func(previous) - func(previous - h)) / h);
            error = Math.abs((current - previous) / previous);
            if (error < relError || i >= 100)
                break;
            i++;
            previous = current;
        }
        System.out.println((int)current+1);
    }


    private static double func(double x){
        return x / articles - factor;
    }
}






