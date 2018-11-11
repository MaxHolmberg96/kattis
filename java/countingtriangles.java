import java.io.*;
import java.util.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while((n = sc.nextInt()) != 0){
            sc.nextLine();
            List<Segment> segments = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                segments.add(new Segment(new Point(sc.nextDouble(), sc.nextDouble()), new Point(sc.nextDouble(), sc.nextDouble())));
            }
            int triangles = 0;
            for (int i = 0; i < segments.size(); i++) {
                for (int j = i+1; j < segments.size(); j++) {
                    for (int k = j+1; k < segments.size(); k++) {
                        if(
                            segments.get(i).intersects(segments.get(j)) &&
                            segments.get(j).intersects(segments.get(k)) &&
                            segments.get(i).intersects(segments.get(k)))
                        {
                            triangles++;
                        }
                    }
                }
            }
            System.out.println(triangles);
        }
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
        return false;
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

