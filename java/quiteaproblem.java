import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String string = scan.nextLine();
            String lower = string.toLowerCase();
            String problem = "problem";
            problem = problem.toLowerCase();
            if(lower.contains(problem))
                System.out.println("yes");
            else
                System.out.println("no");

        }

    }
}
