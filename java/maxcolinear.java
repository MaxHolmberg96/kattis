import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {
    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        int c;
        while((c = sc.getInt()) != 0) {
            ArrayList<Point> points = new ArrayList<>();
            int max = 0;
            for (int i = 0; i < c; i++) {
                points.add(new Point(sc.getInt(), sc.getInt()));
            }
            //For each point in the set of points
            for (int i = 0; i < points.size(); i++) {
                Point p = points.get(i);
                HashMap<Double, Integer> slopes = new HashMap<>();
                for (int j = 0; j < points.size(); j++) {
                    if(!p.equals(points.get(j))){
                        double slope = (points.get(j).getY()-p.getY())/(points.get(j).getX()-p.getX());
                        if(slopes.containsKey(slope)){
                            int n = slopes.get(slope);
                            slopes.put(slope, n+1);
                        }
                        else
                            slopes.put(slope, 1);
                    }
                }
                int maximum = 0;
                for(int k : slopes.values()){
                    if(k > maximum)
                        maximum = k;
                }
                if(maximum > max)
                    max = maximum;
            }
            System.out.println(max+1);
        }
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

