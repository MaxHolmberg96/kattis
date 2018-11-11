import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        int[] panagram = new int[26];
        int[] missingChars = new int[26];
        int counter = 0;
        scan.nextLine();
        for(int i = 0; i < cases; i++){
            String s = scan.nextLine().toLowerCase();
            int length = s.length();
            for(int j = 0; j < length; j++){
                if(s.charAt(j) > 64 && s.charAt(j) < 91 || s.charAt(j) > 96 && s.charAt(j) < 123) {
                    int tmp = (s.charAt(j)) - 97;
                    panagram[tmp]++;
                }
            }
            for(int k = 0; k < panagram.length; k++){
                if(panagram[k] > 0){
                    counter++;
                }
                else{
                    missingChars[k] = 1;
                }

            }
            if(counter == 26){
                System.out.println("pangram");
            }
            else{
                System.out.print("missing ");
                for(int b = 0; b < missingChars.length; b++){
                    if(missingChars[b] == 1){
                        System.out.print((char)(b+97));
                    }

                }
                System.out.println();
            }
            counter = 0;
            panagram = new int[26];
            missingChars = new int[26];
        }
    }
}
