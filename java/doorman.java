import java.io.*;
import java.util.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int abs = sc.nextInt();
        sc.nextLine();
        StringBuilder line = new StringBuilder(sc.nextLine());
        String jumpOvers = "";
        int M = 0, W = 0;
        for (int i = 0; i < line.length();) {
            if(line.charAt(i) == 'M'){
                if(Math.abs((M+1)-W) > abs){
                    if(line.charAt(i+1) == 'W'){
                        W++;
                        line = new StringBuilder("M").append(line.substring(i+2));
                    } else {
                        break;
                    }
                } else {
                    M++;
                    line = new StringBuilder(line.substring(i + 1));
                }
            } else {
                if(Math.abs((W+1)-M) > abs){
                    if(line.charAt(i+1) == 'M'){
                        M++;
                        line = new StringBuilder("W").append(line.substring(i+2));
                    } else {
                        break;
                    }
                } else {
                    W++;
                    line = new StringBuilder(line.substring(i + 1));
                }
            }
        }
        System.out.println(M + W);

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

