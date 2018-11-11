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
        int n;
        n = sc.getInt();
        HashMap<String, Runner> map = new HashMap<>();
        ArrayList<Runner> seconds_time = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.getWord();
            double first_tid = sc.getDouble();
            double second_tid  = sc.getDouble();
            Runner r = new Runner(name, first_tid, second_tid);
            seconds_time.add(r);
            map.put(name, r);
        }
        Collections.sort(seconds_time, new Comparator<Runner>() {
            @Override
            public int compare(Runner o1, Runner o2) {
                if(o1.second > o2.second){
                    return 1;
                }
                else if(o1.second < o2.second){
                    return -1;
                }
                return 0;
            }
        });
        double minTime = Double.MAX_VALUE;
        int added;
        ArrayList<String> bestRunners = new ArrayList<>();
        for (Runner runner : map.values()) {
            double curr_sum = runner.first;
            added = 0;
            ArrayList<String> currentRunners = new ArrayList<>();
            currentRunners.add(runner.name);
            for (int i = 0; i < seconds_time.size() && added != 3; i++) {
                if(!seconds_time.get(i).name.equals(runner.name)) {
                    currentRunners.add(seconds_time.get(i).name);
                    curr_sum += seconds_time.get(i).second;
                    added++;
                }
            }
            if(curr_sum < minTime){
                bestRunners = currentRunners;
                minTime = curr_sum;
            }
        }
        System.out.println(minTime);
        for (String bestRunner : bestRunners) {
            System.out.println(bestRunner);
        }
    }
    static class Runner{
        String name;
        double first;
        double second;

        public Runner(String name, double first, double second) {
            this.name = name;
            this.first = first;
            this.second = second;
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

