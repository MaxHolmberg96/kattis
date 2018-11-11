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
            sc.getInt();
            int j = 0;
            int h = sc.getInt();
            int save = h;
            boolean flag = false;
            if(isPrime(h)) {
                while (h != 1 && j < 100) {
                    h = sum(h);
                    j++;
                }
                if(j != 100) {
                    System.out.println((i + 1) + " " + save + " " + "YES");
                    flag = true;
                }
            }
            if(!flag)
                System.out.println((i+1) + " " + save + " " + "NO");
        }
    }

    private static int sum(int num){
        int sum = 0;
        while(num > 0){
            sum += Math.pow(num%10,2);
            num /= 10;
        }
        return sum;
    }

    static boolean isPrime(int n) {
        if(n == 1)
            return false;
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
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

