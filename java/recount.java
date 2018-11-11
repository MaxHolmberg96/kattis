import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Kattio katt = new Kattio(System.in);
        HashMap<String, Integer> votes = new HashMap<>(100000);
        String s;
        String winner = "";
        String second = "";
        int highest = 0;
        int secondHighest = 0;
        while(!((s = katt.getLine()).equals("***"))){
            if(votes.containsKey(s)){
                int value = votes.get(s) + 1;
                votes.remove(s);
                votes.put(s, value);
                if(value > highest){
                    highest = value;
                    winner = s;
                }
                else if(value > secondHighest){
                    secondHighest = value;
                    second = s;
                }
            }
            else{
                votes.put(s, 1);
            }
        }
        if(highest == secondHighest){
            System.out.println("Runoff!");
        }
        else
            System.out.println(winner);
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