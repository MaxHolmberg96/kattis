import java.io.*;
import java.util.*;
import static java.lang.Math.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        while(!(s = sc.nextLine()).equals("0 0 0")){
            String[] split = s.split(" ");
            double[] d = new double[3];
            d[0] = Double.parseDouble(split[0]);
            d[1] = Double.parseDouble(split[1]);
            d[2] = Double.parseDouble(split[2]);
            double e = 0.000000001;
            Arrays.sort(d);
            
            if(abs(acos((d[0]*d[0]+d[1]*d[1]-d[2]*d[2])/(2.0*d[0]*d[1]))-PI/2) < e){
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }
    }

    private static double max(double a, double b){
        if(a > b){
            return a;
        }
        return b;
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

