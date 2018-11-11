package se.smyto;

import java.io.*;
import java.util.StringTokenizer;

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMore() {
        return peekToken() != null;
    }

    public int Int() {
        return Integer.parseInt(nextToken());
    }

    public double Double() {
        return Double.parseDouble(nextToken());
    }

    public long Long() {
        return Long.parseLong(nextToken());
    }

    public String Word() {
        return nextToken();
    }

    public String Line() {
        try {
            return r.readLine();
        } catch (IOException e) {
            return null;
        }
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