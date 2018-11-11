import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int caseCounter = 0;
        while(scan.hasNextLine()){
            int p = scan.nextInt();
            int[] b = new int[p];
            for(int i = 0; i < p; i++)
                b[i] = scan.nextInt();
            Arrays.sort(b);
            caseCounter++;
            System.out.println("Case " + caseCounter + ": " + b[0] + " " + b[p-1] + " " + (b[p-1] - b[0]));
            scan.nextLine();
        }
    }
}
