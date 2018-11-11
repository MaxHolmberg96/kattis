import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        int y = katt.getInt();
        int x = katt.getInt();
        int zY = katt.getInt();
        int zX = katt.getInt();
        ArrayList<String> mark = new ArrayList<>();
        for(int yv = 0; yv < y; yv++){
            String line = katt.getLine();
            String tmp = "";
            for(int xv = 0; xv < x; xv++){
                for(int i = 0; i < zX; i++){
                    tmp += line.charAt(xv);
                }
            }
            for(int i = 0; i < zY; i++){
                mark.add(tmp);
            }
        }
        for(String s : mark)
            System.out.println(s);

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