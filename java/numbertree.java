import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner katt = new Scanner(System.in);
        int height = katt.nextInt();

        long maxNodes = (long) (Math.pow(2, height+1));

        String word = katt.nextLine();

        int p = 1;
        for(int i = 1; i < word.length(); i++){
            p *= 2;
            if(word.charAt(i) == 'R'){
                p++;
            }
        }
        System.out.println(maxNodes-p);

    }
}



