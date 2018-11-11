import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int targets = sc.nextInt();
        ArrayList<figure> figures = new ArrayList<>();
        String s;
        sc.nextLine();
        for (int i = 0; i < targets; i++) {
            s = sc.nextLine();
            if(s.split(" ")[0].equals("rectangle")){
                figures.add(new Rectangle(new Point(Integer.parseInt(s.split(" ")[1]), Integer.parseInt(s.split(" ")[2])),
                        new Point(Integer.parseInt(s.split(" ")[3]), Integer.parseInt(s.split(" ")[4]))));
            }
            else{
                figures.add(new Circle(new Point(Integer.parseInt(s.split(" ")[1]), Integer.parseInt(s.split(" ")[2])),
                        Integer.parseInt(s.split(" ")[3])));
            }
        }
        int shots = sc.nextInt();
        int count = 0;
        sc.nextLine();
        for (int i = 0; i < shots; i++) {
            s = sc.nextLine();
            Point shot = new Point(Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]));
            for (int j = 0; j < figures.size(); j++) {
                if(figures.get(j).isHit(shot))
                    count++;
            }
            System.out.println(count);
            count=0;
        }
    }
}

abstract class figure{
    public abstract boolean isHit(Point p);
}


class Rectangle extends figure{
    Point bl;
    Point tr;
    public Rectangle(Point bl, Point tr){
        this.bl=bl;
        this.tr=tr;
    }
    public boolean isHit(Point p){
        return (p.getX() >= bl.getX() && p.getX() <= tr.getX()) &&
                (p.getY() >= bl.getY() && p.getY() <= tr.getY());
    }
}

class Circle extends figure{
    Point c;
    int r;
    public Circle(Point c, int r){
        this.c=c;
        this.r=r;
    }
    public boolean isHit(Point p){
        return Math.sqrt(Math.pow(p.getX()-c.getX(), 2) +
                Math.pow(p.getY()-c.getY(), 2)) <= r;
    }
}
