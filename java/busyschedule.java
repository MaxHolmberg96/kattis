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
        int k;
        while((k = sc.getInt()) != 0){
            String[] a = new String[k];
            for (int i = 0; i < k; i++) {
                a[i] = sc.getLine();
            }
            Arrays.sort(a, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String[] s1 = o1.split(" ");
                    String[] s2 = o2.split(" ");
                    if(s1[1].charAt(0) < s2[1].charAt(0)){
                        return -1;
                    }
                    else if(s1[1].charAt(0) > s2[1].charAt(0)){
                        return 1;
                    }
                    else{
                        if(s1[1].charAt(0) == 'a'){
                            String[] s3 = s1[0].split(":");
                            String[] s4 = s2[0].split(":");
                            if(Integer.parseInt(s3[0]) == 12 && Integer.parseInt(s4[0]) == 12){
                                return comp(Integer.parseInt(s3[1]), Integer.parseInt(s4[1]));
                            }
                            if(Integer.parseInt(s3[0]) == 12 && Integer.parseInt(s4[0]) != 12){
                                return -1;
                            }
                            if(Integer.parseInt(s3[0]) != 12 && Integer.parseInt(s4[0]) == 12){
                                return 1;
                            }
                            if(comp(Integer.parseInt(s3[0]), Integer.parseInt(s4[0])) == 0){
                                return comp(Integer.parseInt(s3[1]), Integer.parseInt(s4[1]));
                            }
                            return comp(Integer.parseInt(s3[0]), Integer.parseInt(s4[0]));
                        }
                        else{
                            String[] s3 = s1[0].split(":");
                            String[] s4 = s2[0].split(":");
                            if(Integer.parseInt(s3[0]) == 12 && Integer.parseInt(s4[0]) == 12){
                                return comp(Integer.parseInt(s3[1]), Integer.parseInt(s4[1]));
                            }
                            if(Integer.parseInt(s3[0]) == 12 && Integer.parseInt(s4[0]) != 12){
                                return -1;
                            }
                            if(Integer.parseInt(s3[0]) != 12 && Integer.parseInt(s4[0]) == 12){
                                return 1;
                            }
                            if(comp(Integer.parseInt(s3[0]), Integer.parseInt(s4[0])) == 0){
                                return comp(Integer.parseInt(s3[1]), Integer.parseInt(s4[1]));
                            }
                            return comp(Integer.parseInt(s3[0]), Integer.parseInt(s4[0]));
                        }
                    }
                }
            });
            for (String s : a) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    private static int comp(int a, int b){
        if(a > b) return 1;
        if(a < b) return -1;
        return 0;
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

