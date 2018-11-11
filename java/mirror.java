import java.io.*;
import java.util.*;

public class main {


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        int Test = 0;
        for(int i = 0; i < cases; i++){
            int row = scan.nextInt();
            scan.nextInt();
            scan.nextLine();
            ArrayList<String> rows = new ArrayList<>();
            for(int r = 0; r < row; r++)
                rows.add(scan.nextLine());
            Test++;
            System.out.println("Test " + Test);
            for(int r = row-1; r >= 0; r--){
                System.out.println(new StringBuilder(rows.get(r)).reverse().toString());
            }
        }


    }
}