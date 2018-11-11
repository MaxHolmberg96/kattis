import java.util.ArrayList;
import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int caseCounter = 0;
        loop:
        while(scan.hasNextLine()) {
            caseCounter++;
            int cases = scan.nextInt();
            ArrayList<String> one = new ArrayList<>();
            ArrayList<String> two = new ArrayList<>();
            scan.nextLine();
            for(int i = 0; i < cases; i++){
                if(i % 2 == 0){
                    one.add(scan.nextLine());
                }
                else{
                    two.add(scan.nextLine());
                }
            }
            if(cases != 0)
                System.out.println("SET " + caseCounter);
            for(int i = 0; i < one.size(); i++)
                System.out.println(one.get(i));
            for(int i = two.size()-1; i >= 0; i--)
                System.out.println(two.get(i));
        }
    }
}
