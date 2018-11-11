
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        loops:
        while(scan.hasNextLine()){
            int cases = scan.nextInt();
            if(cases == -1)
                break loops;
            int totDist = 0;
            int hoursAlreadyElapsed = 0;
            for(int i = 0; i < cases; i++){
                int miles = scan.nextInt();
                int hours = scan.nextInt();
                totDist += miles * (hours - hoursAlreadyElapsed);
                hoursAlreadyElapsed = hours;
            }

            System.out.println(totDist + " miles");

        }
    }
}