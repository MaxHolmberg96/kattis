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
        String s = sc.getLine();
        String[] split = new String[2];
        split[0] = s.substring(0, s.length()/2);
        split[1] = s.substring(s.length()/2, s.length());
        int string1sum = 0, string2sum = 0;
        for (int i = 0; i < split[0].length(); i++) {
            string1sum += split[0].charAt(i) - 65;
        }
        for (int i = 0; i < split[1].length(); i++) {
            string2sum += split[1].charAt(i) - 65;
        }
        char[] k = new char[split[0].length()];
        for (int i = 0; i < k.length; i++) {
            char s1 = (char)((((split[0].charAt(i) - 65) + string1sum) % 26) + 65);
            char s2 = (char)((((split[1].charAt(i) - 65) + string2sum) % 26) + 65);
            char s3 = (char)(((s1-65 + s2-65) % 26) + 65);
            k[i] = s3;
        }
        for (int i = 0; i < k.length; i++) {
            System.out.print(k[i]);
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

