import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */

public class main {

    public static void main(String[] args) throws IOException {
        Kattio sc = new Kattio(System.in);
        int R = sc.getInt(), C = sc.getInt();
        char[][] m = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = sc.getLine();
            for (int j = 0; j < C; j++) {
                m[i][j] = s.charAt(j);
            }
        }
        ArrayList<String> words = new ArrayList<>();
        String tmp;
        int count;
        for (int i = 0; i < R; i++) {
            tmp = "";
            count = 0;
            for (int j = 0; j < C; j++) {
                if(m[i][j] == '#') {
                    if (tmp.length() > 1) {
                        words.add(tmp);
                    } else {
                        count = 0;
                        tmp = "";
                    }
                }
                else{
                    count++;
                    tmp += m[i][j];
                }
                if(j == C-1 && count > 1){
                    words.add(tmp);
                }
            }
        }
        for (int i = 0; i < C; i++) {
            tmp = "";
            count = 0;
            for (int j = 0; j < R; j++) {
                if(m[j][i] == '#') {
                    if (tmp.length() > 1) {
                        words.add(tmp);
                    } else {
                        count = 0;
                        tmp = "";
                    }
                }
                else{
                    count++;
                    tmp += m[j][i];
                }
                if(j == R-1 && count > 1){
                    words.add(tmp);
                }
            }
        }
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        System.out.println(words.get(0));
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

