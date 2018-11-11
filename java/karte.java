import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        HashMap<Character, ArrayList<Integer>> suits = new HashMap<>();
        String cards = katt.getLine();
        suits.put('P', new ArrayList<Integer>());
        suits.put('K', new ArrayList<Integer>());
        suits.put('H', new ArrayList<Integer>());
        suits.put('T', new ArrayList<Integer>());
        for(int i = 0; i < cards.length(); i = i+3){
            switch(cards.charAt(i)){
                case 'P':
                    if(suits.get('P').contains(Integer.parseInt(cards.substring(i+1, i+3)))){
                        System.out.println("GRESKA");
                        return;
                    }
                    else
                        suits.get('P').add(Integer.parseInt(cards.substring(i+1, i+3)));
                    break;
                case 'K':
                    if(suits.get('K').contains(Integer.parseInt(cards.substring(i+1, i+3)))){
                        System.out.println("GRESKA");
                        return;
                    }
                    else
                        suits.get('K').add(Integer.parseInt(cards.substring(i+1, i+3)));
                    break;
                case 'H':
                    if(suits.get('H').contains(Integer.parseInt(cards.substring(i+1, i+3)))){
                        System.out.println("GRESKA");
                        return;
                    }
                    else
                        suits.get('H').add(Integer.parseInt(cards.substring(i+1, i+3)));
                    break;
                case 'T':
                    if(suits.get('T').contains(Integer.parseInt(cards.substring(i+1, i+3)))){
                        System.out.println("GRESKA");
                        return;
                    }
                    else
                        suits.get('T').add(Integer.parseInt(cards.substring(i+1, i+3)));
                    break;
            }
        }
        System.out.print(13 - suits.get('P').size() + " ");
        System.out.print(13 - suits.get('K').size() + " ");
        System.out.print(13 - suits.get('H').size() + " ");
        System.out.print(13 - suits.get('T').size() + " ");

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