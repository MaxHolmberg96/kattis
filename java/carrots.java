import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amountOfPeople = scan.nextInt();
        int amountOfProblems = scan.nextInt();

        while(scan.hasNextLine()){
            scan.nextLine();
        }

        System.out.println(amountOfProblems);
    }
}
