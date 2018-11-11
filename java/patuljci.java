import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main {

    private static ArrayList<Integer> list = new ArrayList<>();
    private static int valid = 100;

    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        for (int i = 0; i < 9; i++) {
            list.add(katt.getInt()); 
        }
        permutations(0, 7, new int[7]);
    }


    private static void permutations(int start, int length, int[] arr){
        if(length == 0){
            if(sum(arr) == valid){
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                }
            }
            return;
        }
        for (int i = start; i <= list.size() - length; i++) {
            arr[arr.length - length] =  list.get(i);
            permutations(i+1, length-1, arr);
        }
    }

    private static int sum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { sum += arr[i]; }
        return sum;
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

    public String getLine() {
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

