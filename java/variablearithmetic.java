import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        HashMap<String, Integer> variables = new HashMap<>();
        String s;
        while((s = katt.getLine()) != null){
            String[] split = s.split(" ");
            if(split[0].equals("0") && split.length == 1)
                return;
            if(split.length > 1) {
                if (split[1].equals("=")) {
                    variables.put(split[0], Integer.parseInt(split[2]));
                } else {
                    int sum = 0;

                    String tmp = "";
                    for (int i = 0; i < split.length; i += 2) {
                        if (isDigit(split[i]) >= 0) {
                            sum += isDigit(split[i]);
                        }
                        else {
                            if (variables.containsKey(split[i])) {
                                sum += variables.get(split[i]);
                            } else {
                                tmp += split[i] + " + ";
                            }
                        }
                    }
                    if (tmp.length() > 0) {
                        String tmpp = tmp.substring(0, tmp.length() - 2);
                        if (sum != 0)
                            System.out.println(sum + " + " + tmpp);
                        else
                            System.out.println(tmpp);
                    } else
                        System.out.println(sum);
                }
            }
            else{
                if(variables.containsKey(split[0])){
                    System.out.println(variables.get(split[0]));
                }
                else
                    System.out.println(split[0]);
            }
        }
    }


    private static int isDigit(String s){
        try{
            return Integer.parseInt(s);
        }
        catch(Exception e){
            return -1;
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