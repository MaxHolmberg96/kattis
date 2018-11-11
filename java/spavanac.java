import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = scan.nextInt();
        int minutes = scan.nextInt();

        int total = (hours * 60) + minutes;
        int answer = total - 45;
        int answerHours = answer / 60;
        int answerMinutes = answer % 60;
        if(answerMinutes < 0){
            answerMinutes = 60 + (answerMinutes);
        }

        if(hours == 0 && minutes < 45){
            answerHours = 23;
        }

        System.out.println(answerHours + " " + answerMinutes);


    }
}
