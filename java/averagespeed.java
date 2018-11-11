import java.util.ArrayList;
        import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        String currentTime;
        String lastTime = "";
        double timeElapsed = 0;
        double mps = 0;
        int index = 0;
        double total = 0;
        double totalDistance = 0;
        int reset = 0;
        boolean changed = false;
        while(scan.hasNextLine()){
            input.add(scan.nextLine());
            String[] stringSplit = input.get(index).split(" ");


            // om det är hastighets ändring, spara undan den totala hastigheten
            if(stringSplit.length > 1){
                timeElapsed = timeElapsed(stringSplit[0], input.get(reset).split(" ")[0]);
                totalDistance = (mps * timeElapsed);
                total = total + totalDistance;

            }
            else{
                timeElapsed = timeElapsed(stringSplit[0], input.get(reset).split(" ")[0]);
                totalDistance = (mps * timeElapsed);
            }
            //om det är dags att skriva ut, gör det! den totala och avståndet från förra ändring tills nuvarande tid
            if(stringSplit.length < 2){
                System.out.printf(stringSplit[0] + " " + "%.2f" + " km", (total + totalDistance)/1000);
                System.out.println();
                changed = false;
            }
            else{
                mps = Double.parseDouble(stringSplit[1]) / 3.6;
                reset = index;
                changed = true;
            }
            index++;
        }


    }

    public static double timeElapsed(String now, String prev){
        String[] nowd = now.split(":");
        String[] prevd = prev.split(":");
        double hours;
        double minutes;
        double seconds;
        hours = (Double.parseDouble(nowd[0]) - Double.parseDouble(prevd[0])) * 3600;
        minutes = (Double.parseDouble(nowd[1]) - Double.parseDouble(prevd[1])) * 60;
        seconds = (Double.parseDouble(nowd[2]) - Double.parseDouble(prevd[2]));
        double elapsed = hours + minutes + seconds;
        return elapsed;
    }
}
