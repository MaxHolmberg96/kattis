import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {
    public static void main(String[] args) throws IOException{
        Kattio sc = new Kattio(System.in);
        int c = 1;
        while(true){
            String s = sc.getLine();
            if(s.equals("END")) break;
            ArrayList<Integer> star_index = new ArrayList<>();
            if(s.charAt(0) != '*' || s.charAt(s.length()-1) != '*'){
                System.out.println(c++ + " NOT EVEN");
            }
            else{
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i) == '*'){
                        star_index.add(i);
                    }
                }
                int[] lengths = new int[star_index.size()-1];
                for (int i = 0; i < lengths.length; i++) {
                    lengths[i] = (star_index.get(i+1)-star_index.get(i))-1;
                }
                boolean set = false;
                loops:
                for (int i = 0; i < lengths.length; i++) {
                    for (int j = i+1; j < lengths.length; j++) {
                        if(lengths[i] != lengths[j]){
                            System.out.println(c++ + " NOT EVEN");
                            set = true;
                            break loops;
                        }
                    }
                }
                if(!set){
                    System.out.println(c++ + " EVEN");
                }
            }
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

