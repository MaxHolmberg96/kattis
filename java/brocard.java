import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();
        int b = 0;
        for (int i = 0; i < cases; i++) {
            String s = sc.nextLine();
            Point A = new Point(Double.parseDouble(s.split(" ")[1]), Double.parseDouble(s.split(" ")[2]));
            Point B = new Point(Double.parseDouble(s.split(" ")[3]), Double.parseDouble(s.split(" ")[4]));
            Point C = new Point(Double.parseDouble(s.split(" ")[5]), Double.parseDouble(s.split(" ")[6]));
            Triangle triangle = new Triangle(A, B, C);
            triangle.moveToOrigio();
            triangle.rotateABtoXaxis();
            triangle.calculateBrocard();
            b++;
            System.out.print(b + " ");
            triangle.printBrocardPoint();
        }
    }


    private static double slope(Point p1, Point p2){
        return (p1.getX()-p2.getX()) / (p2.getY()-p1.getY());
    }

    private static Point midVectorPoint(Point originPoint, Vector<Double> u){
        return new Point(originPoint.getX() + ((0.5)*u.get(0)), originPoint.getY() + (0.5*u.get(1)));
    }

    public static double cot(double angle){
        return 1/Math.tan(angle);
    }

    public static double acot(double angle){ return Math.atan(1/angle);}

    public static double vectorLength(Vector<Double> u){
        return Math.sqrt(Math.pow(u.get(0),2)+Math.pow(u.get(1),2));
    }

    public static Vector<Double> vector(Point p1, Point p2){
        Vector<Double> u = new Vector<>(2);
        u.add(0,p2.getX()-p1.getX());
        u.add(1, p2.getY()-p1.getY());
        return u;
    }

    public static double add(Vector<Double> u, Vector<Double> v){
        return (u.get(0)*v.get(0)) + (u.get(1)*v.get(1));
    }

    public static double angle(Vector<Double> u, Vector<Double> v){
        return Math.acos((add(u,v))/(vectorLength(u)*vectorLength(v)));
    }


    static class Triangle{
        Point A;
        Point B;
        Point C;
        Point OldA;
        double aAngle;
        double bAngle;
        double cAngle;
        double brocard;
        double AangleP;
        double PangleP;
        double BangleP;
        double APlength;
        Point brocardPoint;

        double angle;


        public Triangle(Point A, Point B, Point C){
            this.A=A;
            this.B=B;
            this.C=C;
            aAngle = angle(vector(A,C), vector(A,B));
            bAngle = angle(vector(B,C), vector(B,A));
            cAngle = angle(vector(C,A), vector(C,B));
            brocard = acot(cot(aAngle) + cot(bAngle) + cot(cAngle));

        }

        public void moveToOrigio(){
            OldA = A;
            A = A.subtract(A);
            B = B.subtract(OldA);
            C = C.subtract(OldA);
        }

        public void printCoordinates(){
            System.out.println("A: (" + A.getX() + ", " + A.getY() + ")");
            System.out.println("B: (" + B.getX() + ", " + B.getY() + ")");
            System.out.println("C: (" + C.getX() + ", " + C.getY() + ")");
            System.out.println("Brocard Point: (" + brocardPoint.getX() + ", " + brocardPoint.getY() + ")");
            System.out.println();
            System.out.println("A angle: " + aAngle + "radians");
            System.out.println("B angle: " + bAngle + "radians");
            System.out.println("C angle: " + cAngle + "radians");
            System.out.println("Brocard angle: " + brocard + " radians");
            System.out.println("Brocard angle: " + Math.toDegrees(brocard) + " degrees");
        }

        private Point rotate(double radians, Point p){
            double newX = (p.getX()*Math.cos(radians)) - (p.getY()*Math.sin(radians));
            double newY = (p.getX()*Math.sin(radians)) + (p.getY()*Math.cos(radians));
            return new Point(newX, newY);
        }

        public void rotateABtoXaxis(){
            angle = Math.acos(B.getX()/vectorLength(vector(A,B)));
            if(B.getY() > 0){
                angle = -angle;
                B = rotate(angle, B);
                C = rotate(angle, C);
            }
            else{
                B = rotate(angle, B);
                C = rotate(angle, C);
            }
        }


        public void calculateBrocard(){
            AangleP = brocard;
            BangleP = bAngle-brocard;
            PangleP = Math.PI-BangleP-AangleP;
            APlength = (vectorLength(vector(A,B))*Math.sin(BangleP))/Math.sin(PangleP);
            /*
            System.out.println(AangleP);
            System.out.println(PangleP);
            System.out.println(BangleP);
            System.out.println(APlength);
            */
            brocardPoint = new Point(APlength*Math.cos(AangleP), APlength*Math.sin(AangleP));
        }

        public void printBrocardPoint(){
            brocardPoint = rotate(-angle, brocardPoint);
            brocardPoint = brocardPoint.add(OldA);
            System.out.println(brocardPoint.getX() + " " + brocardPoint.getY());
        }
    }
}

class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point subtract(Point p){
        return new Point(x-p.getX(), y-p.getY());
    }

    public Point add(Point p){
        return new Point(x+p.getX(), y+p.getY());
    }
}

