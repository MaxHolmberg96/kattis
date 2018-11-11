
import java.util.*;


/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" ");
            String[] morning = line[3].split(":");
            String[] evening = line[4].split(":");
            int morningHour = Integer.parseInt(morning[0]);
            int morningMinute = Integer.parseInt(morning[1]);
            int eveningHour = Integer.parseInt(evening[0]);
            int eveningMinute = Integer.parseInt(evening[1]);

            int totalHour = eveningHour - morningHour;
            int totalMinute = eveningMinute - morningMinute;
            if(totalMinute < 0){
                totalHour--;
                totalMinute+= 60;
            }

            System.out.println(line[0] + " " + line[1] + " " + line[2] + " " + totalHour + " hours " + totalMinute + " minutes");

        }
    }
}