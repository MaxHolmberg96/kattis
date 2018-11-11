import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main {
    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        int counter = 0;
        HashSet<Integer> cds = new HashSet<>();
        while(katt.hasMoreTokens()){
            counter = 0;
            int Jack = katt.getInt();
            int Jill = katt.getInt();
            if(Jack == 0 && Jill == 0)
                break;

            for(int i = 0; i < Jack; i++){
                int p = katt.getInt();
                cds.add(p);
            }

            for(int i = 0; i < Jill; i++) {
                int p = katt.getInt();
                if (cds.contains(p))
                    counter++;
            }

            System.out.println(counter);
            cds.clear();
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

            public String getLine() throws IOException {
                return r.readLine();
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
