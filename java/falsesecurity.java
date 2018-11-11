import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        String line;
        while((line = katt.getLine()) != null) {
            line = line.toLowerCase();
            String numberString = "";
            String morseCode = "";
            for (int i = 0; i < line.length(); i++) {
                int length = toMorse(line.charAt(i)).length();
                morseCode += toMorse(line.charAt(i));
                numberString += "" + length;
            }
            numberString = new StringBuilder(numberString).reverse().toString();
            String output = "";
            int index = 0;
            for(int i = 0; index < numberString.length();){
                output += fromMorse(morseCode.substring(i, i + (int)numberString.charAt(index)-48));
                i += (int)numberString.charAt(index) - 48;
                index++;
            }
            System.out.println(output.toUpperCase());
        }

    }

    private static String toMorse(char key){
        switch(key){
            case 'a':
                return ".-";

            case 'b':
                return "-...";

            case 'c':
                return "-.-.";

            case 'd':
                return "-..";

            case 'e':
                return ".";

            case 'f':
                return "..-.";

            case 'g':
                return "--.";

            case 'h':
                return "....";

            case 'i':
                return "..";

            case 'j':
                return ".---";

            case 'k':
                return "-.-";

            case 'l':
                return ".-..";

            case 'm':
                return "--";

            case 'n':
                return "-.";

            case 'o':
                return "---";

            case 'p':
                return ".--.";

            case 'q':
                return "--.-";

            case 'r':
                return ".-.";

            case 's':
                return "...";

            case 't':
                return "-";

            case 'u':
                return "..-";

            case 'v':
                return "...-";

            case 'w':
                return ".--";

            case 'x':
                return "-..-";

            case 'y':
                return "-.--";

            case 'z':
                return "--..";

            case '_':
                return "..--";

            case ',':
                return ".-.-";

            case '.':
                return "---.";

            case '?':
                return "----";

        }
        return "" + key;
    }

    private static String fromMorse(String s){
        switch(s){
            case ".-":
                return "a";

            case "-...":
                return "b";

            case "-.-.":
                return "c";

            case "-..":
                return "d";

            case ".":
                return "e";

            case "..-.":
                return "f";

            case "--.":
                return "g";

            case "....":
                return "h";

            case "..":
                return "i";

            case ".---":
                return "j";

            case "-.-":
                return "k";

            case ".-..":
                return "l";

            case "--":
                return "m";

            case "-.":
                return "n";

            case "---":
                return "o";

            case ".--.":
                return "p";

            case "--.-":
                return "q";

            case ".-.":
                return "r";

            case "...":
                return "s";

            case "-":
                return "t";

            case "..-":
                return "u";

            case "...-":
                return "v";

            case ".--":
                return "w";

            case "-..-":
                return "x";

            case "-.--":
                return "y";

            case "--..":
                return "z";

            case "..--":
                return "_";

            case ".-.-":
                return ",";

            case "---.":
                return ".";

            case "----":
                return "?";

        }











        return "" + s;
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