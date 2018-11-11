import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */

public class main {

    public static void main(String[] args) throws IOException {
        Kattio sc = new Kattio(System.in);
        int k = sc.getInt();
        for (int i = 0; i < k; i++) {
            Point book = new Point(sc.getDouble(), sc.getDouble());
            ArrayList<Point> candles = new ArrayList<>();
            int nr_c = sc.getInt();
            for (int j = 0; j < nr_c; j++) {
                candles.add(new Point(sc.getDouble(), sc.getDouble()));
            }
            boolean light = false;
            for (Point candle : candles) {
                if(dist(book, candle) <= 8){
                    System.out.println("light a candle");
                    light = true;
                    break;
                }
            }
            if(!light){
                System.out.println("curse the darkness");
            }
        }
    }

    private static double dist(Point a, Point b){
        return Math.sqrt(Math.pow(b.x-a.x,2) + Math.pow(b.y-a.y,2));
    }
}

class Point{
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
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

