import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        String cards = katt.getLine();
        int T3 = 0;
        int C3 = 0;
        int G3 = 0;
        int TS = 0;
        int CS = 0;
        int GS = 0;
        int tot7 = 0;
        for(int i = 0; i < cards.length(); i++){
            switch(cards.charAt(i)){
                case 'T':
                    T3++;
                    TS++;
                    break;
                case 'C':
                    C3++;
                    CS++;
                    break;
                case 'G':
                    G3++;
                    GS++;
                    break;
            }
            if(T3 >= 1 && C3 >= 1 & G3 >= 1){
                tot7++;
                T3--;
                C3--;
                G3--;
            }
        }
        int sum = (int) Math.round( Math.pow(TS, 2) + Math.pow(CS, 2) + Math.pow(GS, 2) );
        sum += tot7*7;
        System.out.println(sum);

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