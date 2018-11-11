import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        int faces1 = katt.getInt();
        int faces2 = katt.getInt();
        HashMap<Integer, Integer> sum = new HashMap<>();
        for(int i = 1; i <= faces1; i++){
            for(int j = 1; j <= faces2; j++){
                if(sum.containsKey(i+j)){
                    int p = j+i;
                    int value = sum.get(p);
                    sum.put(p, value + 1);
                }
                else{
                    int p = j+i;
                    sum.put(i+j, 1);
                }
            }
        }
        int highest = 0;
        for(int key : sum.keySet()){
            if(highest < sum.get(key))
                highest = sum.get(key);
        }
        ArrayList<Integer> output = new ArrayList<>();
        for(int key : sum.keySet()){
            if(highest == sum.get(key))
                output.add(key);
        }
        Collections.sort(output);
        for(int i : output)
            System.out.println(i);
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