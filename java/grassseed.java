import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double price = scan.nextDouble();
        double totalPrice = 0;
        int nLawns = scan.nextInt();
        for(int i = 0; i < nLawns; i++){
            double width = scan.nextDouble();
            double height = scan.nextDouble();
            double area = width*height;
            totalPrice += area*price;
        }
        DecimalFormat df = new DecimalFormat("#.000000");
        System.out.printf(df.format(totalPrice));
    }
}