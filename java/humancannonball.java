import java.io.*;
import java.util.*;
import static java.lang.Math.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {

    private static final int SPEED = 5;

    public static void main(String[] args){
        Kattio katt = new Kattio(System.in);
        Point a = new Point(katt.getDouble(), katt.getDouble());
        Point b = new Point(katt.getDouble(), katt.getDouble());
        int n = katt.getInt();
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node(a, 0));
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(new Point(katt.getDouble(), katt.getDouble()), 1));
        }
        nodes.add(new Node(b, 2));
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                if(i != j) {
                    nodes.get(i).links.add(calculateLink(nodes.get(i), nodes.get(j)));
                }
            }
        }
        /* perform djikstra and print the total weight */

        nodes.get(0).dist = 0;
        nodes.get(0).visited = true;
        ArrayList<Node> unvisited = new ArrayList<>();
        for (int i = nodes.size()-1; i >= 1; i--) {
            unvisited.add(nodes.get(i));
        }
        Node current = nodes.get(0);
        for(Link link : current.links){
            Node target = link.target;
            if(target.dist > current.dist+link.weight){
                target.dist = current.dist+link.weight;
            }
        }
        boolean t = false;
        while(!unvisited.isEmpty()){
            current = findSmallest(unvisited);
            for(Link link : current.links){
                Node target = link.target;
                if(target.dist > current.dist+link.weight){
                    target.dist = current.dist+link.weight;
                }
            }
            current.visited = true;
            if(nodes.get(nodes.size()-1).visited){
                t = true;
            }
        }
        if(t){
            System.out.println(nodes.get(nodes.size()-1).dist);
        } else {
            throw new OutOfMemoryError();
        }
    }

    private static Node findSmallest(ArrayList<Node> unvisited){
        int index = 0;
        double smallest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < unvisited.size(); i++) {
            if(unvisited.get(i).dist < smallest){
                smallest = unvisited.get(i).dist;
                index = i;
            }
        }
        return unvisited.remove(index);
    }

    private static Link calculateLink(Node n1, Node n2){
        Link link = new Link();
        if(n1.flag == 0 || n1.flag == 2){
            double lengthBetweenNodes = dist(n1.point, n2.point);
            link.weight = lengthBetweenNodes/SPEED;
            link.target = n2;
        } else {
            double lengthBetweenNodes = dist(n1.point, n2.point);
            lengthBetweenNodes -= 50;
            lengthBetweenNodes = abs(lengthBetweenNodes);
            link.weight = (lengthBetweenNodes/SPEED) + 2;
            link.target = n2;
        }
        return link;
    }


    private static Point newPointWithAngle(Point p1, double angle, double length){
        return new Point((p1.x)+(length*cos(angle)), (p1.y)+(length*sin(angle)));
    }

    private static double polarAngle(Point p1, Point p2){
        return acos((p2.x-p1.x)/dist(p1,p2));
    }

    private static double dist(Point p1, Point p2){
        return sqrt(pow(p2.x-p1.x,2)+pow(p2.y-p1.y,2));
    }

    private static double area(Segment s1, Segment s2){
        Point v1 = s1.p2.subtract(s1.p1);
        Point v2 = s2.p2.subtract(s1.p1);
        return new Point(0,0).cross(v1, v2);

    }

    private static double max(double a, double b){
        if(a > b){
            return a;
        }
        return b;
    }

}

class Link{
    double weight;
    Node target;

    @Override
    public boolean equals(Object o) {
        Link l = (Link)o;
        return weight==l.weight && target.equals(l.target);
    }
}


class Node{
    ArrayList<Link> links = new ArrayList<Link>();
    Point point;
    int flag;
    double dist = Double.POSITIVE_INFINITY;
    boolean visited = false;

    public Node(Point point, int flag) {
        this.point = point;
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        Node n = (Node)o;
        return point.equals(n.point) && links.equals(n.links) && flag == n.flag
                && dist == n.dist && visited == n.visited;
    }
}


class map{

    Integer L;
    Integer H;
    int value;

    public map(int value, Integer L, Integer H){
        this.L = L;
        this.H = H;
        this.value = value;
    }
}


class Triangle{

    Point p1;
    Point p2;
    Point p3;
    double area;
    int index;

    public Triangle(Point p1, Point p2, Point p3, int index) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.index = index;
    }

    public Triangle area(){
        area =  Math.abs(new Point(0, 0).cross(p2.subtract(p1), p3.subtract
                (p1)));
        return this;
    }
}

class Segment{
    Point p1;
    Point p2;


    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean intersects(Segment segment){

        Point h = new Point(0, 0);

        double abc = h.cross(p2.subtract(p1), segment.p1.subtract(p1));
        double abd = h.cross(p2.subtract(p1), segment.p2.subtract(p1));

        double dca = h.cross(segment.p2.subtract(segment.p1), p1.subtract(segment.p1));
        double dcb = h.cross(segment.p2.subtract(segment.p1), p2.subtract(segment.p1));

        if(sign(abc) != sign(abd) && sign(dca) != sign(dcb)){
            return true;
        }
        double error = 0.00000000001;
        /* CHECK IF THEY ARE ALL COOLINEAR */
        if(abs(abc) < error && abs(abd) < error && abs(dca) < error && abs(dcb) < error){
            /* check the projection on x and y axis */
            if(xProjectionIntersect(this, segment) && yProjectionIntersect(this, segment)){
                return true;
            }
        }
        return false;
    }

    public static boolean xProjectionIntersect(Segment s1, Segment s2){
        if(s1.p1.x < s1.p2.x){
            if(s2.p1.x < s2.p2.x){
                return s2.p1.x <= s1.p2.x;
            } else {
                return s2.p2.x <= s1.p2.x;
            }
        } else {
            if(s2.p1.x < s2.p2.x){
                return s2.p1.x <= s1.p1.x;
            } else {
                return s2.p2.x <= s1.p1.x;
            }
        }
    }

    public static boolean yProjectionIntersect(Segment s1, Segment s2){
        if(s1.p1.y < s1.p2.y){
            if(s2.p1.y < s2.p2.y){
                return s2.p1.y <= s1.p2.y;
            } else {
                return s2.p2.y <= s1.p2.y;
            }
        } else {
            if(s2.p1.y < s2.p2.y){
                return s2.p1.y <= s1.p1.y;
            } else {
                return s2.p2.y <= s1.p1.y;
            }
        }
    }



    public static int sign(double x){
        if(x == 0){
            return 0;
        }
        if(x < 0){
            return -1;
        }
        else {
            return 1;
        }
    }



}


class Point{

    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point subtract(Point p){
        return new Point(p.x-x, p.y-y);
    }

    public double cross(Point p1, Point p2){
        return (p1.x*p2.y) - (p1.y*p2.x);
    }

    @Override
    public boolean equals(Object o) {
        Point p = (Point)o;
        return x==p.x && y==p.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}




class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    public String getLine() throws IOException { return r.readLine(); }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}

