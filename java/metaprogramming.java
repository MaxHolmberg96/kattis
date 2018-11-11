import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> table = new HashMap<>();
        while(scan.hasNextLine()){
            String[] lineSplit = scan.nextLine().split(" ");
            if(lineSplit[0].equals("define")){
                table.put(lineSplit[2],lineSplit[1]);
            }


            loops:
            if(lineSplit[0].equals("eval")) {
                if(table.containsKey(lineSplit[1]) && table.containsKey(lineSplit[3])){
                    if(lineSplit[2].equals("=")){
                        if(Integer.parseInt(table.get(lineSplit[1])) == Integer.parseInt(table.get(lineSplit[3])))
                            System.out.println("true");
                        else
                            System.out.println("false");
                    }
                    else if(lineSplit[2].equals("<")){
                        if(Integer.parseInt(table.get(lineSplit[1])) < Integer.parseInt(table.get(lineSplit[3])))
                            System.out.println("true");
                        else
                            System.out.println("false");
                    }
                    else if(lineSplit[2].equals(">")){
                        if(Integer.parseInt(table.get(lineSplit[1])) > Integer.parseInt(table.get(lineSplit[3])))
                            System.out.println("true");
                        else
                            System.out.println("false");
                    }
                }
                else{
                    System.out.println("undefined");
                }
            }
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