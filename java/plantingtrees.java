import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        int p = katt.getInt();
        int[] arr = new int[p];
        for (int i = 0; i < p; i++) {
            arr[i] = katt.getInt();
        }
        int maxIndex = 2;
        ArrayList<Integer> a = new ArrayList<>();
        for(int k : arr)
            a.add(k);
        Collections.sort(a, (ints, t1) -> {
            if(ints > t1)
                return -1;
            else if(t1 > ints)
                return 1;
            else
                return 0;
        });
        int sum = 1;
        for(int i = 0; i < a.size(); i++){
            if((i+1) + a.get(i) > sum) {
                sum = i+1 + a.get(i);
            }
        }
        System.out.println(sum+1);
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