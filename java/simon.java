import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        boolean beenHere = false;
        for(int i = 0; i < cases+1; i++){
            String string = scan.nextLine();
            String[] splitString = string.split(" ");
            if(splitString[0].equals("simon")) {
                if(splitString.length > 1)
                    if (splitString[1].equals("says")) {
                        for(int j = 2; j < splitString.length; j++){
                            System.out.print(splitString[j] + " ");
                        }
                        if(i < cases)
                            System.out.println();
                        beenHere = true;
                    }
            }
            if(i != 0 && i < cases && !beenHere)
                System.out.println();
            beenHere = false;
        }
    }
}
