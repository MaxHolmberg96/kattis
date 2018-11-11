import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        ArrayList<String> output = new ArrayList<>();
        String line;
        while((line = katt.getLine()) != null){
            for (int i = 0; i < line.length(); i++) {
                System.out.print(keyPress(line.charAt(i)));
            }
            System.out.println();
        }


    }

    private static char keyPress(char key){
        switch(key){

            //FIRST ROW

            case '`':
                return '`';

            case '1':
                return '`';

            case '2':
                return '1';

            case '3':
                return '2';

            case '4':
                return '3';

            case '5':
                return '4';

            case '6':
                return '5';

            case '7':
                return '6';

            case '8':
                return '7';

            case '9':
                return '8';

            case '0':
                return '9';

            case '-':
                return '0';

            case '=':
                return '-';

            //SECOND ROW

            case 'Q':
                return 'Q';

            case 'W':
                return 'Q';

            case 'E':
                return 'W';

            case 'R':
                return 'E';

            case 'T':
                return 'R';

            case 'Y':
                return 'T';

            case 'U':
                return 'Y';

            case 'I':
                return 'U';

            case 'O':
                return 'I';

            case 'P':
                return 'O';

            case '[':
                return 'P';

            case ']':
                return '[';

            case '\\':
                return ']';

            //THIRD ROW

            case 'A':
                return 'A';

            case 'S':
                return 'A';

            case 'D':
                return 'S';

            case 'F':
                return 'D';

            case 'G':
                return 'F';

            case 'H':
                return 'G';

            case 'J':
                return 'H';

            case 'K':
                return 'J';

            case 'L':
                return 'K';

            case ';':
                return 'L';

            case '\'':
                return ';';

            //FOURTH ROW

            case 'Z':
                return 'Z';

            case 'X':
                return 'Z';

            case 'C':
                return 'X';

            case 'V':
                return 'C';

            case 'B':
                return 'V';

            case 'N':
                return 'B';

            case 'M':
                return 'N';

            case ',':
                return 'M';

            case '.':
                return ',';

            case '/':
                return '.';


        }
        return key;
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