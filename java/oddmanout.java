import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        HashMap<Integer, Integer> personInv = new HashMap<>();
        for(int i = 0, cases = katt.getInt(); i < cases; i++){
            int persons = katt.getInt();
            for(int j = 0; j < persons; j++){
                int p = katt.getInt();
                if(personInv.containsKey(p))
                    personInv.put(p, p);
                else
                    personInv.put(p, 0);
            }
            System.out.print("Case #" + (i+1) + ": ");
            for(int key : personInv.keySet()){
                if(personInv.get(key) == 0)
                    System.out.print(key);
            }
            System.out.println();
            personInv.clear();
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