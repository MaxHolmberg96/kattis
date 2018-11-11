import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();

        scan.nextLine();
        for(int i = 0; i < cases; i++){
            String line = scan.nextLine();
            char c = line.charAt(0);
            int index = 1;
            boolean finished = false;
            int length = 0;
            while(!finished) {
                loop:
                for (int j = index; j < line.length(); j++) {
                    if (c == line.charAt(j)) {
                        index = j;
                        break loop;
                    }
                }
                length = index;
                String subString = line.substring(0, length);
                int j = length;
                for(;;j+=length){
                    if(!(j < line.length() && j+length < line.length()+1 && subString.equals(line.substring(j, j+length)))){
                        break;
                    }
                }

                if(j == line.length()){
                    finished = true;
                }
                if(j > line.length()-length && !finished){
                    if(line.substring(line.length()-(line.length()-j), line.length()).equals(subString.substring(0, line.length()-j))){
                        finished = true;
                    }
                }






                index++;


            }
            System.out.println(length);


        }

    }







}

