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
        while(true){
            int x = sc.getInt(), y = sc.getInt();
            if(x == 0 && y == 0) break;
            char[][] arr = new char[y][x];
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                strings.add(sc.getLine());
            }
            for (int i = 0; i < y; i++){
                for (int j = 0; j < x; j++) {
                    arr[i][j] = strings.get(j).charAt(i);
                }
            }

            Arrays.sort(arr, new Comparator<char[]>() {
                @Override
                public int compare(char[] o1, char[] o2) {
                    return tostring(o1).compareTo(tostring(o2));
                }
            });
            for (int i = 0; i < arr[0].length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j][i]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static String tostring(char[] s){
        String r = "";
        for (int i = 0; i < s.length; i++) {
            r+=s[i];
        }
        return r.toLowerCase();
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

