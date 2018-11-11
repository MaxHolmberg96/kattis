
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
        String[] input = sc.getLine().split(" ");
        BigInteger files = new BigInteger(input[0]);
        int bits = Integer.parseInt(input[1]);
        BigInteger sum = new BigInteger("0");
        for(int i = 0; i <= bits; i++){
            sum = sum.add(BigInteger.valueOf(2).pow(i));
        }
        if(sum.compareTo(files) >= 0){
            System.out.println("yes");
        }
        else
            System.out.println("no");
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

