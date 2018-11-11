import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class asciifigurerotation {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        ArrayList<String> strings = new ArrayList<>();
        int n;
        boolean first = true;
        while((n = katt.getInt()) != 0){
            if(!first){
                strings.add("\n");
            } else {
                first = false;
            }
            ArrayList<String> input = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                input.add(katt.getLine());
            }
            char[][] matrix = convert(input);
            if(matrix != null){
                char[][] transpose = transpose(matrix);
                char[][] output = flip(transpose);
                int r = check(output);
                int a = cropA(output);
                int b = cropB(output);
                for (int i = 0; i < output.length; i++) {
                    String s = "";
                    for (int j = 0; j < output.length; j++) {
                        if(checkIfNotMore(i, j, output)) {
                            continue;
                        }
                        else if(j > r && i > a && i < b){
                            s += output[i][j];
                        }
                    }
                    strings.add(s);
                }
            }
        }
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            if(string.equals("\n")){
                System.out.println();
            } else if(!string.equals("")){
                System.out.println(string);
            }
        }
    }

    private static boolean checkIfNotMore(int row, int column, char[][] output){
        int c = 0;
        for (int i = column; i < output.length; i++) {
            if(output[row][i] == ' '){
                c++;
            }
        }
        return c == output.length-column;
    }

    private static int cropA(char[][] output){
        for (int i = 0; i < output.length; i++) {
            int c = 0;
            int j = 0;
            for (; j < output.length; j++) {
                if(output[i][j] == ' '){
                    c++;
                }
            }
            if(c != output.length){
                return i-1;
            }
        }
        return -1;
    }

    private static int cropB(char[][] output){
        for (int i = output.length-1; i >= 0; i--) {
            int c = 0;
            int j = 0;
            for (; j < output.length; j++) {
                if(output[i][j] == ' '){
                    c++;
                }
            }
            if(c != output.length){
                return i+1;
            }

        }
        return -1;
    }

    private static int check(char[][] output){
        for (int i = 0; i < output.length; i++) {
            int c = 0;
            for (int j = 0; j < output.length; j++) {
                if (output[j][i] == ' ') {
                    c++;
                }
            }
            if(c != output.length){
                return i-1;
            }
        }
        return -1;
    }

    private static char[][] transpose(char[][] matrix){
        char[][] output = new char[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < output.length; j++) {
                if(matrix[i][j] == '-'){
                    output[j][i] = '|';
                } else if(matrix[i][j] == '|'){
                    output[j][i] = '-';
                } else {
                    output[j][i] = matrix[i][j];
                }
            }
        }
        return output;
    }

    private static char[][] flip(char[][] transpose){
        char[][] output = new char[transpose.length][transpose.length];
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose.length; j++) {
                output[j][i] = transpose[j][transpose.length-1-i];
            }
        }
        return output;
    }

    private static char[][] convert(ArrayList<String> input){
        int l = longestRow(input);
        char[][] matrix = null;
        if(l > input.size()){
            matrix = new char[l][l];
            for (int i = 0; i < input.size(); i++) {
                for (int j = 0; j < input.get(i).length(); j++) {
                    matrix[i][j] = input.get(i).charAt(j);
                }
            }
        } else if(input.size() >= l){
            matrix = new char[input.size()][input.size()];
            for (int i = 0; i < input.size(); i++) {
                for (int j = 0; j < input.get(i).length(); j++) {
                    matrix[i][j] = input.get(i).charAt(j);
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][j] = ' ';
                }
            }
        }


        return matrix;
    }

    private static int longestRow(ArrayList<String> input){
        int longest = 0;
        for (int i = 0; i < input.size(); i++)
            if(input.get(i).length() > longest)
                longest = input.get(i).length();
        return longest;
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

