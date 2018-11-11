import java.io.*;
import java.util.*;
import static java.lang.Math.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {

    public static void main(String[] args){
        Kattio katt = new Kattio(System.in);
        int n = katt.getInt();
        HashMap<Integer, map> map = new HashMap<>();
        Integer currH = null, currL = null;
        /* go right and search for H */
        for (int i = 0; i < n; i++) {
            int a = katt.getInt();
            /* special case first */
            if(i == 0) {
                map.put(i, new map(a, currL, currH));
                currH = a;
            }
            else if(currH < a){
                map.put(i, new map(a, currL, currH));
                currH = a;
            } else {
                map.put(i, new map(a, currL, currH));
            }
        }
        /* go left and search for L */
        for (int i = n-1; i >= 0; i--) {
            int b = map.get(i).value;
            /* special case first */
            if(i == n-1){
                map.put(i, new map(b, currL, map.get(i).H));
                currL = b;
            } else if(currL > b){
                map.put(i, new map(b, currL, map.get(i).H));
                currL = b;
            } else {
                map.put(i, new map(b, currL, map.get(i).H));
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map m = map.get(i);
            if(m.H == null && m.L > m.value){
                ans++;
            } else if(m.L == null && m.H < m.value){
                ans++;
            }
            else if(m.H != null && m.L != null && m.H < m.value && m.L > m.value){
                ans++;
            }
        }
        System.out.println(ans);
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

