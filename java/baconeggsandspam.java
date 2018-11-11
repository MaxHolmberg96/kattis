import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
        Kattio katt = new Kattio(System.in);
        int n;
        boolean first = true;
        HashMap<String, ArrayList<String>> foodOrderedBy = new HashMap<>();
        while((n = katt.getInt()) != 0){
            if(!first)
                System.out.println();
            for(int i = 0; i < n; i++){
                String[] line = katt.getLine().split(" ");
                for(int j = 1; j < line.length; j++){
                    if(foodOrderedBy.get(line[j]) != null){
                        ArrayList a = foodOrderedBy.get(line[j]);
                        a.add(line[0]);
                        foodOrderedBy.remove(line[j]);
                        foodOrderedBy.put(line[j], a);
                    }
                    else{
                        ArrayList<String> a = new ArrayList<>();
                        a.add(line[0]);
                        foodOrderedBy.put(line[j], a);
                    }
                }
            }
            ArrayList<String> sorted = new ArrayList<>();
            for(String key : foodOrderedBy.keySet()){
                sorted.add(key);
            }
            Collections.sort(sorted);
            for(int i = 0; i < sorted.size(); i++){
                ArrayList<String> a = foodOrderedBy.get(sorted.get(i));
                Collections.sort(a);
            }
            for(int i = 0; i < sorted.size(); i++){
                ArrayList<String> a = foodOrderedBy.get(sorted.get(i));
                System.out.print(sorted.get(i) + " ");
                for(int j = 0; j < a.size(); j++){
                    System.out.print(a.get(j) + " ");
                }
                System.out.println();
            }

            first = false;
            foodOrderedBy.clear();
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