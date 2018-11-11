import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */

public class main {
    private static BigDecimal n;

    public static void main(String[] args) throws IOException {
        Kattio sc = new Kattio(System.in);
        int n, m;
        n = sc.getInt(); m = sc.getInt();
        HashMap<Integer, Team> upper = new HashMap<>();
        HashMap<Integer, Team> lower = new HashMap<>();
        Team us = new Team(0, 0, 1);
        for (int i = 0; i < m; i++) {
            int t, p;
            t = sc.getInt(); p = sc.getInt();
            if(t == 1){
                us.a++;
                us.b += p;
                ArrayList<Team> to_rem = new ArrayList<>();
                for (Integer integer : upper.keySet()) {
                    Team comp = upper.get(integer);
                    if(us.a > comp.a || (us.a == comp.a && us.b <= comp.b)){
                        to_rem.add(comp);
                    }
                }
                for (int j = 0; j < to_rem.size(); j++) {
                    lower.put(to_rem.get(j).name, to_rem.get(j));
                    upper.remove(to_rem.get(j).name);
                }
            }
            else{
                if(upper.containsKey(t)){
                    upper.get(t).a++;
                    upper.get(t).b += p;
                }
                else if(lower.containsKey(t)){
                    lower.get(t).a++;
                    lower.get(t).b += p;
                    if(lower.get(t).a > us.a || (lower.get(t).a == us.a && lower.get(t).b < us.b)){
                        upper.put(lower.get(t).name, lower.get(t));
                        lower.remove(lower.get(t).name);
                    }
                }
                else{
                    if(1 > us.a || (1 == us.a && p < us.b)){
                        upper.put(t, new Team(1, p, t));
                    }
                    else{
                        lower.put(t, new Team(1, p, t));
                    }
                }
            }
            System.out.println(upper.size()+1);
        }
    }
    static class Team{
        int a, b;
        int name;

        public Team(int a, int b, int name) {
            this.a = a;
            this.b = b;
            this.name = name;
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

