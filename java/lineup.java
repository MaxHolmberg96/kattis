import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */

public class main {

    public static void main(String[] args) throws IOException {
        Kattio sc = new Kattio(System.in);
        int N = sc.getInt();
        String[] c = new String[N];
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            c[i] = sc.getLine();
        }
        int count = 0, i;
        for (i = 0; i < c.length-1; i++) {
            for (int j = 0; j < c[i].length(); j++) {
                if(c[i].charAt(j) < c[i+1].charAt(j)){
                    count++;
                    break;
                }
                else if(c[i].charAt(j) > c[i+1].charAt(j)) break;
                if(j == c[i].length()-1){
                    if(c[i].length() < c[i+1].length()){
                        count++;
                        break;
                    }
                }
            }
        }
        if(count == i){
            System.out.println("INCREASING");
            flag = true;
        }
        count = 0;
        if(!flag){
            for (i = 0; i < c.length-1; i++) {
                for (int j = 0; j < c[i].length(); j++) {
                    if(c[i].charAt(j) > c[i+1].charAt(j)){
                        count++;
                        break;
                    }
                    else if(c[i].charAt(j) < c[i+1].charAt(j)) break;
                    if(j == c[i].length()-1){
                        if(c[i].length() > c[i+1].length()){
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        if(count == i){
            System.out.println("DECREASING");
        }
        else if(!flag)
            System.out.println("NEITHER");
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

