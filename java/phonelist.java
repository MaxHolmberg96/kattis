import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        for(int i = 0, cases = katt.getInt(); i < cases; i++){
            ArrayList<String> strings = new ArrayList<>();
            int ca = katt.getInt();

            int c = 0;
            for(; c < ca; c++){
                strings.add(katt.getLine());
            }
            c = 0;
            Collections.sort(strings);
            loops:
            for(; c < strings.size()-1; c++){
                if(isSubStringOf(strings.get(c), strings.get(c+1))){
                    System.out.println("NO");
                    break loops;
                }
            }
            if(c == strings.size()-1)
                System.out.println("YES");
        }
    }


    private static boolean isSubStringOf(String s, String string){
        if(string.length() < s.length())
            return false;
        else {
            return string.substring(0, s.length()).equals(s);
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