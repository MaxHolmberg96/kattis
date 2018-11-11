import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        int lines = katt.getInt();
        HashMap<String, Integer> DOM = new HashMap<>();
        HashMap<String, Integer> Kattis = new HashMap<>();
        for(int i = 0; i < lines; i++){
            String answer = katt.getWord();
            if(!(DOM.containsKey(answer)))
                DOM.put(answer, 1);
            else{
                int value = DOM.get(answer);
                DOM.remove(answer);
                DOM.put(answer, value+1);
            }
        }
        for(int i = 0; i < lines; i++){
            String answer = katt.getWord();
            if(!(Kattis.containsKey(answer)))
                Kattis.put(answer, 1);
            else{
                int value = Kattis.get(answer);
                Kattis.remove(answer);
                Kattis.put(answer, value+1);
            }
        }
        int counter = 0;
        for(String key : DOM.keySet()){
            if(Kattis.containsKey(key)){
                if(DOM.get(key) > Kattis.get(key))
                    counter += Kattis.get(key);
                else
                    counter += DOM.get(key);
            }
        }

        System.out.println(counter);
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