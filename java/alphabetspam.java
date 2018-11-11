import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String line = scan.nextLine();

            int whiteCounter = 0;
            int lowerCounter = 0;
            int upperCounter = 0;
            int symbolCounter = 0;

            for(int i = 0; i < line.length(); i++){

                if(line.charAt(i) == '_')
                    whiteCounter++;
                else if(line.charAt(i) >= 'a' && line.charAt(i) <= 'z')
                    lowerCounter++;
                else if(line.charAt(i) >= 'A' && line.charAt(i) <= 'Z')
                    upperCounter++;
                else
                    symbolCounter++;
            }
        
            System.out.println((double)whiteCounter/line.length());
            System.out.println((double)lowerCounter/line.length());
            System.out.println((double)upperCounter/line.length());
            System.out.println((double)symbolCounter/line.length());

        }
    }
}