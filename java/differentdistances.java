import java.awt.*;
import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s;
        while(!(s = sc.nextLine()).equals("0")) {
            String[] split = s.split(" ");
            Point p1 = new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
            Point p2 = new Point(Double.parseDouble(split[2]), Double.parseDouble(split[3]));
            double p = Double.parseDouble(split[4]);
            System.out.println(distance(p1, p2, p));
        }
    }
    private static double distance(Point p1, Point p2, double p){
        return Math.pow((Math.pow(Math.abs(p1.getX()-p2.getX()),p) + Math.pow(Math.abs(p1.getY()-p2.getY()),p)), (double)1/p);
    }
}

class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}