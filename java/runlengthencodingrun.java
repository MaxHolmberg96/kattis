import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class runlengthencodingrun {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] line = sc.readLine().split(" ");
        if(line[0].equals("E")) {
            System.out.println(encode(line[1]));
        } else {
            System.out.println(decode(line[1]));
        }
    }

    private static String decode(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i++);
            int n = (int)s.charAt(i) - '0';
            for (int j = 0; j < n; j++) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    private static String encode(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            char c = s.charAt(i);
            builder.append(c);
            int j = i + 1;
            while(j < s.length() && s.charAt(j) == c) {
                count++;
                j++;
            }
            builder.append(count);
            i += count - 1;
        }
        return builder.toString();
    }

}
