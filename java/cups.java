
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cups = scan.nextInt();
        ArrayList<Integer> keys = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        scan.nextLine();
        for(int i = 0; i < cups; i++){
            if(scan.hasNextInt()){
                String[] line = scan.nextLine().split(" ");
                keys.add(Integer.parseInt(line[0])/2);
                map.put(Integer.parseInt(line[0])/2, line[1]);
            }
            else{
                String[] line = scan.nextLine().split(" ");
                keys.add(Integer.parseInt(line[1]));
                map.put(Integer.parseInt(line[1]), line[0]);
            }
        }
        Collections.sort(keys);
        for(int i = 0; i < keys.size(); i++)
            System.out.println(map.get(keys.get(i)));
    }
}
