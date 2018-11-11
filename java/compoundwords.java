import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        String line;
        ArrayList<String> strings = new ArrayList<>();
        HashSet<String> output = new HashSet<>();
        while((line = katt.getLine()) != null){
            String[] s = line.split(" ");
            for(int i = 0; i < s.length; i++)
                strings.add(s[i]);
        }
        for(int i = 0; i < strings.size(); i++){
            String tmp = strings.get(i);
            for(int j = 0; j < strings.size(); j++){
                if(!tmp.equals(strings.get(j))){
                    output.add(tmp + strings.get(j));
                }
            }
        }
        ArrayList<String> sorted = new ArrayList<>();
        for(String key : output){
            sorted.add(key);
        }
        Collections.sort(sorted);
        for(String s : sorted)
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