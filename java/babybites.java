import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class babybites {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        sc.readLine();
        boolean makesSense = true;
        String[] bites = sc.readLine().split(" ");
        for (int i = 1; i <= bites.length; i++) {
            if(!bites[i-1].equals("mumble") && !bites[i-1].equals(Integer.toString(i))) {
                makesSense = false;
            }
        }
        System.out.println(makesSense ? "makes sense" : "something is fishy");
    }

}
