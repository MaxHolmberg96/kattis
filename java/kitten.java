import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> tree = new ArrayList<>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split(" ");
            if(Integer.parseInt(split[0]) == -1)
                break;
            else
                tree.add(line);
        }
        int kitten = Integer.parseInt(tree.get(0));
        int index = 0;
        int[] catPath = new int[1000];
        for(int i = 0; i < tree.size(); i++) {
            String[] splitString = tree.get(i).split(" ");
            for (int j = 1; j < splitString.length; j++) {
                if (kitten == Integer.parseInt(splitString[j])) {
                    catPath[index] = Integer.parseInt(splitString[j]);
                    kitten = Integer.parseInt(splitString[0]);
                    index++;
                    i = 0;
                }
            }
        }
        for(int i = 0; catPath[i] != 0; i++){
            System.out.print(catPath[i] + " ");
        }
        System.out.print(kitten);


    }







}

