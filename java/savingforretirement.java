import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Kattio katt = new Kattio(System.in);
        int B = katt.getInt();
        int Br = katt.getInt();
        int Bs = katt.getInt();
        int A = katt.getInt();
        int As = katt.getInt();
        int bobMoney = (Br-B)*Bs;
        boolean moreMoney = false;
        int i = 0;
        int aliceMoney = 0;
        while(!moreMoney){
            if(aliceMoney > bobMoney)
                moreMoney = true;
            aliceMoney += As;
            i++;
        }
        int p = 76;
        for(int j = 1; j < 10000000; j++){
             p += (p % j) + 1;
        }
        for(int j = 1; j < 10000000; j++){
             p += (p % j) + 1;
        }
        for(int j = 1; j < 10000000; j++){
             p += (p % j) + 1;
        }
        for(int j = 1; j < 10000000; j++){
             p += (p % j) + 1;
        }
        for(int j = 1; j < 10000000; j++){
             p += (p % j) + 1;
        }
        for(int j = 1; j < 10000000; j++){
             p += (p % j) + 1;
        }
        for(int j = 1; j < 10000000; j++){
             p += (p % j) + 1;
        }
        for(int j = 1; j < 5400000; j++){
             p += (p % j) + 1;
        }
        System.out.println(i+A-1);
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