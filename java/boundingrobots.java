import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String s;
        while(!(s = scan.nextLine()).equals("0 0")){
            int w = Integer.parseInt(s.split(" ")[0]);
            int l = Integer.parseInt(s.split(" ")[1]);
            int rX = 0, rY = 0, TX = 0, TY = 0, operations = Integer.parseInt(scan.nextLine().split(" ")[0]);
            for (int i = 0; i < operations; i++) {
                s = scan.nextLine();
                switch(s.charAt(0)){
                    case 'u':
                        rY+=Integer.parseInt(s.split(" ")[1]);
                        TY+=Integer.parseInt(s.split(" ")[1]);
                        rY = correct(rY, l);
                        break;
                    case 'd':
                        rY-=Integer.parseInt(s.split(" ")[1]);
                        TY-=Integer.parseInt(s.split(" ")[1]);
                        rY = correct(rY, l);
                        break;
                    case 'r':
                        rX+=Integer.parseInt(s.split(" ")[1]);
                        TX+=Integer.parseInt(s.split(" ")[1]);
                        rX = correct(rX, w);
                        break;
                    case 'l':
                        rX-=Integer.parseInt(s.split(" ")[1]);
                        TX-=Integer.parseInt(s.split(" ")[1]);
                        rX = correct(rX, w);
                        break;

                }
            }
            System.out.println("Robot thinks " + TX + " " + TY);
            System.out.println("Actually at " + rX + " " + rY);
            System.out.println();
        }
    }

    private static int correct(int coordinate, int room){
        coordinate = (coordinate < 0) ? 0 : coordinate;
        coordinate = (coordinate > room-1) ? room-1 : coordinate;
        return coordinate;
    }
}