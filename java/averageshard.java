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
        int T = sc.getInt();
        for (int i = 0; i < T; i++) {
            sc.getLine();
            int NCS = sc.getInt(), NE = sc.getInt();
            double[] NCS_students = new double[NCS], NE_students = new double[NE];
            double NCS_Baverage = 0, NE_Baverage = 0;
            for (int j = 0; j < NCS_students.length; j++) {
                NCS_students[j] = sc.getInt();
                NCS_Baverage += NCS_students[j];
            }
            for (int j = 0; j < NE_students.length; j++) {
                NE_students[j] = sc.getInt();
                NE_Baverage += NE_students[j];
            }
            int count = 0;
            boolean set = false;
            Arrays.sort(NCS_students);
            for (int j = 0; j < NCS_students.length; j++) {
                double NCS_average = 0, NE_average;
                NE_average = NE_Baverage + NCS_students[j];
                NE_average = NE_average/(NE_students.length + 1);
                NCS_average = NCS_Baverage;
                NCS_average = (NCS_average-NCS_students[j])/(NCS_students.length-1);
                if(NE_average > NE_Baverage/NE_students.length && NCS_average > NCS_Baverage/NCS_students.length){
                    count++;
                    set = true;
                }
                else if(set){
                    break;
                }
                //System.out.println("Average before NCS: " + NCS_Baverage + " Average before NE: " + NE_Baverage + " j : " + j + "  NCS: " + NCS_average + " NE: " + NE_average);
            }
            System.out.println(count);
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

