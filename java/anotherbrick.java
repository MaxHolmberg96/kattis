import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class main {
    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        int h = katt.getInt();
        int w = katt.getInt();
        int n = katt.getInt();

        int sum = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int d = katt.getInt();
            arr.add(d);
        }
        int tot = 0;
        int index = 0;
        int t = 1;
        int i = 0;
        for(; i < h; i++){
            loop:
            for(int j = 0; j < w; j++){
                sum += arr.get(index);
                if(sum + arr.get(index+1) > w){
                    System.out.println("NO");
                    return;
                }
                if(sum + arr.get(index+1) == w){
                    index += 2;
                    break loop;
                }
                index++;
            }
            sum = 0;
        }
        if(i == h)
            System.out.println("YES");
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
