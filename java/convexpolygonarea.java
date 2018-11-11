import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {
    public static void main(String[] args) throws IOException{
        Kattio sc = new Kattio(System.in);
        int d = sc.getInt();
        for (int j = 0; j < d; j++) {
            int c = sc.getInt();
            Point[] points = new Point[c];
            for (int i = 0; i < c; i++) {
                points[i] = new Point(sc.getInt(), sc.getInt());
            }
            //determine area
            double area = 0;
            for (int i = 0; i < c - 1; i++) {
                area += cross(points[i], points[i + 1]);
            }
            area += cross(points[c - 1], points[0]);
            area /= 2;
            DecimalFormat format = new DecimalFormat("0.0");
            area = Math.abs(area);
            String summa = format.format(area);
            System.out.println(summa.replaceAll("[,]", "."));
        }
    }

    public static double determinant2x2(double[][] m){
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    public static double cross(Point a, Point b){
        return a.getX()*b.getY()-a.getY()*b.getX();
    }


    public static double crossProduct2d(Vector<Double> u, Vector<Double> v){
        if(u.size() == v.size() && u.size() == 2) {
            return u.get(0) * v.get(1) - u.get(1) * v.get(0);
        }
        else{
            throw new IllegalArgumentException("Vectors are different sized or not of size two");
        }
    }

    public static double angle(Vector<Double> u, Vector<Double> v){
        return Math.acos((dotProduct(u,v))/(vectorLength(u)*vectorLength(v)));
    }

    public static double vectorLength(Vector<Double> u){
        double sum = 0;
        for (int i = 0; i < u.size(); i++)
            sum+=Math.pow(u.get(i), 2);
        return Math.sqrt(sum);
    }

    public static double dotProduct(Vector<Double> u, Vector<Double> v){
        double sum = 0;
        if(u.size() == v.size())
            for (int i = 0; i < u.size(); i++) {
                sum += u.get(i)*v.get(i);
            }
        else{
            throw new IllegalArgumentException("Different sized vectors");
        }
        return sum;
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

