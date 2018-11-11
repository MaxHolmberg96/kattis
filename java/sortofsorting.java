import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        int cases;
        boolean first = true;
        while(katt.hasMoreTokens()){
            if((cases = katt.getInt()) == 0)
                return;
            else if(!first)
                System.out.println();
            first = false;
            ArrayList<String> names = new ArrayList<>();
            for(int i = 0; i < cases; i++)
                names.add(katt.getWord());
            names.sort((string1, string2) -> {
                if(string1.charAt(0) < string2.charAt(0))
                    return -1;
                else if(string1.charAt(0) > string2.charAt(0))
                    return 1;
                else{
                    if(string1.charAt(1) < string2.charAt(1))
                        return -1;
                    else if(string1.charAt(1) > string2.charAt(1))
                        return 1;
                    else
                        return 0;
                }
            });
            for(int i = 0; i < names.size(); i++)
                System.out.println(names.get(i));
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