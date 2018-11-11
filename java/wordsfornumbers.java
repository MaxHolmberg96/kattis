import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class wordsfornumbers {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        String line;
        ArrayList<String> list = new ArrayList<>();
        while((line = katt.getLine()) != null){
            list.add(replace(line.split(" ")).toString());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static StringBuilder replace(String[] line){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < line.length; i++) {
            int number = getNumber(line[i]);
            if(number == -1){
                stringBuilder.append(line[i]);
            } else {
                if (i == 0) {
                    String s = convert(number);
                    stringBuilder.append((char)(s.charAt(0) - 32));
                    stringBuilder.append(s.substring(1, s.length()));
                } else {
                    stringBuilder.append(convert(number));
                }
            }
            stringBuilder.append(" ");
        }
        return stringBuilder;
    }

    private static int getNumber(String s){
        try{
            return Integer.parseInt(s);
        } catch (Exception e){
            return -1;
        }
    }

    private static String convert(int number){
        if(number >= 20){
            int ceil = ((int)number/10)*10;
            switch (ceil){
                case 20:
                    if(lowNumber(number-ceil).equals("")){
                        return "twenty";
                    } else {
                        return "twenty-" + lowNumber(number - ceil);
                    }
                case 30:
                    if(lowNumber(number-ceil).equals("")){
                        return "thirty";
                    } else {
                        return "thirty-" + lowNumber(number - ceil);
                    }
                case 40:
                    if(lowNumber(number-ceil).equals("")){
                        return "forty";
                    } else {
                        return "forty-" + lowNumber(number - ceil);
                    }
                case 50:
                    if(lowNumber(number-ceil).equals("")){
                        return "fifty";
                    } else {
                        return "fifty-" + lowNumber(number - ceil);
                    }
                case 60:
                    if(lowNumber(number-ceil).equals("")){
                        return "sixty";
                    } else {
                        return "sixty-" + lowNumber(number - ceil);
                    }
                case 70:
                    if(lowNumber(number-ceil).equals("")){
                        return "seventy";
                    } else {
                        return "seventy-" + lowNumber(number - ceil);
                    }
                case 80:
                    if(lowNumber(number-ceil).equals("")){
                        return "eighty";
                    } else {
                        return "eighty-" + lowNumber(number - ceil);
                    }
                case 90:
                    if(lowNumber(number-ceil).equals("")){
                        return "ninety";
                    } else {
                        return "ninety-" + lowNumber(number - ceil);
                    }
            }
        } else if (number >= 10) {
            switch (number){
                case 10:
                    return "ten";
                case 11:
                    return "eleven";
                case 12:
                    return "twelve";
                case 13:
                    return "thirteen";
                case 14:
                    return "fourteen";
                case 15:
                    return "fifteen";
                case 16:
                    return "sixteen";
                case 17:
                    return "seventeen";
                case 18:
                    return "eighteen";
                case 19:
                    return "nineteen";
            }
        } else {
            return number(number);
        }
        throw new OutOfMemoryError();
    }


    private static String number(int n){
        switch (n) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }

    private static String lowNumber(int n){
        switch (n) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
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


