import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String s;
        while(!(s = scan.nextLine()).equals("0 0 0")){
            double r = Double.parseDouble(s.split(" ")[0]), realArea = Math.PI*Math.pow(r,2);
            int c = Integer.parseInt(s.split(" ")[2]), m = Integer.parseInt(s.split(" ")[1]);
            double rektArea = (r*2)*(r*2);
            DecimalFormat df = new DecimalFormat("#.00000000");
            String b = "" + df.format(realArea) + " " + df.format(((double)c/m)*rektArea);
            System.out.println(b.replaceAll(",", "."));
        }
    }
}