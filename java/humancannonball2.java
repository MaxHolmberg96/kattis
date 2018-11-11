import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        for(int i = 0, cases = katt.getInt(); i < cases; i++) {
            System.out.println(function(katt.getDouble(), katt.getDouble(), katt.getDouble(), katt.getDouble(), katt.getDouble()) ? "Safe" : "Not Safe");
        }
    }

    public static boolean function(double v0, double theta, double x1, double h1, double h2){
        double y = (v0 * (x1 / (Math.cos(Math.toRadians(theta)) * v0)) *
                Math.sin(Math.toRadians(theta))) - (0.5 * 9.81 *
                Math.pow((x1 / (Math.cos(Math.toRadians(theta)) * v0)), 2));
        if(y < h2-1 && y > h1+1)
            return true;
        return false;
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

    public String getLine() throws IOException {return r.readLine();}



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