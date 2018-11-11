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
        String s;
        while((s = sc.getLine()) != null){
            int occurences = Integer.parseInt(s);
            ArrayList<String> text = new ArrayList<>();
            HashMap<String, Integer> freq = new HashMap<>();
            while(true){
                String curr = sc.getLine();
                if(curr.equals("EndOfText")) break;
                text.add(curr.toLowerCase());
            }
            for (int i = 0; i < text.size(); i++) {
                String[] split = text.get(i).split("[^a-z]");
                for (int j = 0; j < split.length; j++) {
                    if(split[j].length() > 0){
                        if (freq.containsKey(split[j])) {
                            int a = freq.get(split[j]);
                            freq.put(split[j], a + 1);
                        } else {
                            freq.put(split[j], 1);
                        }

                    }
                }
            }
            ArrayList<String> a = new ArrayList<>(freq.size());
            for (String s1 : freq.keySet()) {
                if(occurences == freq.get(s1)){
                    a.add(s1);
                }
            }
            Collections.sort(a);
            int k = 0;
            for (String s1 : a) {
                if(s1.length() > 1) {
                    System.out.println(s1);
                    k++;
                }
            }
            if(k == 0){
                System.out.println("There is no such word.");
            }
        }
    }

    static private String check_valid(String s){
        char c = s.charAt(s.length()-1);
        String sub = s.substring(0, s.length()-1);
        if((c > 64 && c < 91) || (c > 96 && c < 123)){
            return s;
        }
        return sub;
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

