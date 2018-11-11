import java.util.*;

public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> numberLine = new ArrayList<>();
        numberLine.add(scan.nextInt());
        numberLine.add(scan.nextInt());
        numberLine.add(scan.nextInt());
        boolean finished = false;
        int counter = 0;
        while(!finished){
            if(numberLine.get(2) - numberLine.get(1) >= numberLine.get(1) - numberLine.get(0) && numberLine.get(2) - numberLine.get(1) != 1){
                numberLine.remove(0);
                numberLine.add(1, numberLine.get(0)+1);
                counter++;
            }
            else if(numberLine.get(2) - numberLine.get(1) < numberLine.get(1) - numberLine.get(0) && numberLine.get(1) - numberLine.get(0) != 1){
                numberLine.remove(2);
                numberLine.add(1, numberLine.get(0)+1);
                counter++;
            }
            else
                finished = true;
        }
        System.out.println(counter);
    }
}