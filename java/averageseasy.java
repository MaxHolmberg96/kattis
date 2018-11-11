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
            float[] NCS_students = new float[NCS], NE_students = new float[NE];
            for (int j = 0; j < NCS_students.length; j++) {
                NCS_students[j] = sc.getInt();
            }
            for (int j = 0; j < NE_students.length; j++) {
                NE_students[j] = sc.getInt();
            }
            int count = 0;
            float NCS_Baverage = get_avg(NCS_students), NE_Baverage = get_avg(NE_students);
            for (int j = 0; j < NCS_students.length; j++) {
                float NCS_average = 0, NE_average = 0;
                for (int k = 0; k < NCS_students.length; k++) {
                    if(k != j){
                        NCS_average += NCS_students[k];
                    }
                }
                for (int k = 0; k < NE_students.length; k++) {
                    NE_average += NE_students[k];
                }
                NE_average += NCS_students[j];
                NE_average = NE_average/(NE_students.length + 1);
                NCS_average = NCS_average/(NCS_students.length-1);
                if(NE_average > NE_Baverage && NCS_average > NCS_Baverage){
                    count++;
                }
                //System.out.println("Average before NCS: " + NCS_Baverage + " Average before NE: " + NE_Baverage + " j : " + j + "  NCS: " + NCS_average + " NE: " + NE_average);
            }
            System.out.println(count);
        }
    }

    public static float get_avg(float[] students){
        float avg = 0;
        for (int i = 0; i < students.length; i++) {
            avg += students[i];
        }
        return avg/students.length;
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

