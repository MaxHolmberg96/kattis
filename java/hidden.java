import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */

public class main {

    public static void main(String[] args) throws IOException {
        Kattio sc = new Kattio(System.in);
        ArrayList<Character> a = new ArrayList<>();
        String[] s = sc.getLine().split(" ");
        for (int i = 0; i < s[0].length(); i++) {
            a.add(s[0].charAt(i));
        }
        boolean failed = false;
        for (int i = 0; i < s[1].length(); i++) {
            if(a.contains(s[1].charAt(i))){
                if(a.indexOf(s[1].charAt(i)) != 0 && !failed){
                    System.out.println("FAIL");
                    failed = true;
                }
                else{
                    a.remove(0);
                }
            }

        }
        if(!failed && a.size() == 0)
            System.out.println("PASS");
        else if(!failed)
            System.out.println("FAIL");
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

