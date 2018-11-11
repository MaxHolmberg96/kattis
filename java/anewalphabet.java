import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        String line = katt.getLine().toLowerCase();
        for (int i = 0; i < line.length(); i++) {
            System.out.print(keyPress(line.charAt(i)));
        }



    }

    private static String keyPress(char key){
        switch(key){

            case 'a':
                return "@";

            case 'b':
                return "8";

            case 'c':
                return "(";

            case 'd':
                return "|)";

            case 'e':
                return "3";

            case 'f':
                return "#";

            case 'g':
                return "6";

            case 'h':
                return "[-]";

            case 'i':
                return "|";

            case 'j':
                return "_|";

            case 'k':
                return "|<";

            case 'l':
                return "1";

            case 'm':
                return "[]\\/[]";

            case 'n':
                return "[]\\[]";

            case 'o':
                return "0";

            case 'p':
                return "|D";

            case 'q':
                return "(,)";

            case 'r':
                return "|Z";

            case 's':
                return "$";

            case 't':
                return "']['";

            case 'u':
                return "|_|";

            case 'v':
                return "\\/";

            case 'w':
                return "\\/\\/";

            case 'x':
                return "}{";

            case 'y':
                return "`/";

            case 'z':
                return "2";
        }
        return "" + key;
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