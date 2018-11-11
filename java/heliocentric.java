import java.util.Scanner;

/**
 * Created by Max Holmberg on 2017-07-08.
 */
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCounter = 1;
        int dayCounter = 0;
        while(sc.hasNextLine()){
            dayCounter = 0;
            String[] line = sc.nextLine().split(" ");
            int earth = Integer.parseInt(line[0]);
            int mars = Integer.parseInt(line[1]);
            loop:
            while(true){
                if(earth%365==0 && mars%687==0){
                    System.out.println("Case " + caseCounter + ": " + dayCounter);
                    caseCounter++;
                    break loop;
                }
                else{
                    dayCounter++;
                    earth++;
                    mars++;
                    if(earth == 365){
                        earth = 0;
                    }
                    if(mars == 687){
                        mars = 0;
                    }
                }
            }
        }

    }
}
