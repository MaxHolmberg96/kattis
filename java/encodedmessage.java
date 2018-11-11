import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cases = Integer.parseInt(s.split(" ")[0]);
        for (int i = 0; i < cases; i++) {
            s = sc.nextLine();
            int rekt = 0;
            //construct rekt
            rekt = (int)Math.sqrt(s.length());
            int index = rekt-1;
            for (int j = 0; j < s.length(); j++) {
                System.out.print(s.charAt(index));
                index = (index + rekt) % s.length();
                if((j+1) % rekt == 0)
                    index--;
            }
            System.out.println();
        }
    }
}

