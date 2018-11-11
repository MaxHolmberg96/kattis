import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio scan = new Kattio(System.in);
        int bounds = scan.getInt();
        char[][] chess = new char[bounds][bounds];
        boolean correct = true;

        for(int i = 0; i < bounds; i++){
            int x = scan.getInt();
            int y = scan.getInt();
            chess[y][x] = 'Q';
        }
        loops:
        for(int y = 0; y < bounds; y++){
            for(int x = 0; x < bounds; x++){
                if(chess[y][x] == 'Q'){
                    for(int r = 0; r < bounds; r++){
                        if(chess[y][r] == 'Q' && r != x){
                            correct = false;
                            break loops;
                        }
                    }
                    for(int c = 0; c < bounds; c++){
                        if(chess[c][x] == 'Q' && c != y){
                            correct = false;
                            break loops;
                        }
                    }
                    int x2 = x;
                    int y2 = y;
                    for(; x2 > 0 && y2 < bounds; x2--){
                        if(chess[y2][x2] == 'Q' && x2 != x){
                            correct = false;
                            break loops;
                        }
                        y2++;
                    }

                    x2 = x;
                    y2 = y;
                    for(; x2 < bounds && y2 < bounds; x2++){
                        if(chess[y2][x2] == 'Q' && x2 != x){
                            correct = false;
                            break loops;
                        }
                        y2++;
                    }
                }
            }
        }

        if(correct)
            System.out.println("CORRECT");
        else
            System.out.println("INCORRECT");
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