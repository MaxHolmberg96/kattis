import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        int hands = katt.getInt();
        String dominantSuit = katt.getWord();
        String line;
        int sum = 0;
        for(int i = 0; i < hands*4; i++){
            line = katt.getLine();
            char card = line.charAt(0);
            char suit = line.charAt(1);
            sum += sumFor(card, suit, dominantSuit);
        }
        System.out.println(sum);
    }

    private static int sumFor(char card, char suit, String dominantSuit){
        switch(card){
            case 'A':
                return 11;

            case 'K':
                return 4;

            case 'Q':
                return 3;

            case 'J':
                if(suit == dominantSuit.charAt(0))
                    return 20;
                return 2;

            case 'T':
                return 10;

            case '9':
                if(suit == dominantSuit.charAt(0))
                    return 14;
                return 0;

            case '8':
                return 0;

            case '7':
                return 0;


        }
        return 0;
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