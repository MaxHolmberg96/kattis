import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        loops:
        while(scan.hasNextLine()) {
            int bjorn = scan.nextInt();
            if (bjorn == 0)
                break loops;
            loop:
            for (int i = 11; true; i++) {
                String sumbjorn = Integer.toString(bjorn);
                int sum = 0;
                for (int j = 0; j < sumbjorn.length(); j++) {
                    sum = sum + (sumbjorn.charAt(j) - 48);
                }

                String sumbjornTot = Integer.toString(bjorn * i);
                int sum2 = 0;
                for (int j = 0; j < sumbjornTot.length(); j++) {
                    sum2 = sum2 + (sumbjornTot.charAt(j) - 48);
                    ;
                }

                if (sum == sum2) {
                    System.out.println(i);
                    break loop;
                }
            }
        }

    }
}
