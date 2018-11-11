
import java.io.*;
import java.util.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {
    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        int c = sc.getInt();
        for (int k = 0; k < c; k++) {
            int n = sc.getInt();
            splat[] list = new splat[n];
            for (int i = 0; i < n; i++) {
                list[i] = new splat(sc.getDouble(), sc.getDouble(), sc.getDouble(), sc.getWord());
            }
            int m = sc.getInt();
            for (int i = 0; i < m; i++) {
                double x = sc.getDouble(), y = sc.getDouble();
                int count = 0;
                for (int j = list.length-1; j >= 0; j--) {
                    if(list[j].inRange(x, y)) {
                        System.out.println(list[j].getColor());
                        break;
                    }
                    if(j == 0){
                        System.out.println("white");
                    }
                }
            }
        }
    }

    public static double dist(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    public static class splat{
        double radius;
        double v;
        double x;
        double y;
        String color;

        public splat(double x, double y, double v, String color){
            this.x=x;
            this.y=y;
            this.v=v;
            this.color=color;
            radius=Math.sqrt(v/Math.PI);
        }

        public boolean inRange(double xC, double yC){
            return dist(xC, yC, x, y) < radius;
        }

        public String getColor() {
            return color;
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