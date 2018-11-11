import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */

public class main {

    public static void main(String[] args) throws IOException {
        Kattio sc = new Kattio(System.in);
        int total = 0, count = 0;
        HashMap<Character, Integer> problems = new HashMap<>();
        String s;
        while((s = sc.getLine()) != null){
            String[] split = s.split(" ");
            int time = Integer.parseInt(split[0]);
            if(time < 0) break;
            char c = split[1].charAt(0);
            if(split[2].equals("right")){
                if(problems.containsKey(c)){
                    total = total + time + (problems.get(c)*20);
                }
                else{
                    total += time;
                }
                count++;
            }
            else{
                if(problems.containsKey(c)){
                    problems.put(c, problems.get(c)+1);
                }
                else{
                    problems.put(c, 1);
                }
            }
        }
        System.out.println(count + " " + total);
    }
    static class Problem{
        char name;
        boolean correct;
        int stacked_time;

        public Problem(char name, boolean correct, int stacked_time) {
            this.name = name;
            this.correct = correct;
            this.stacked_time = stacked_time;
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

    public String getLine() throws IOException { return r.readLine(); }



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

