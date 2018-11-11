import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> table = new HashMap<>();
        while(scan.hasNextLine()){
            String[] lineSplit = scan.nextLine().split(" ");
            if(lineSplit[0].equals("def")){
                table.put(lineSplit[1],lineSplit[2]);
            }


            loops:
            if(lineSplit[0].equals("calc")){
                int total = 0;
                int b = 2;
                char[] operators = new char[1000];
                int index = 1;
                operators[0] = '+';
                for(; b < lineSplit.length; b+=2){
                    operators[index] = lineSplit[b].charAt(0);
                    index++;
                }
                boolean change;

                index = 0;
                if((operators.length-1) % 2 == 0)
                    change = false;
                else
                    change = true;
                for(int i = 1; i < lineSplit.length; i = i+2){
                    if(table.containsKey(lineSplit[i])) {
                        if (operators[index] == '+') {
                            total += Integer.parseInt(table.get(lineSplit[i]));
                        }
                        else if (operators[index] == '-') {
                            total -= Integer.parseInt(table.get(lineSplit[i]));
                        }

                        index++;
                    }
                    else {
                        for (int k = 1; k < lineSplit.length; k++) {
                            System.out.print(lineSplit[k] + " ");
                        }
                            System.out.println("unknown");
                        break loops;
                    }
                }
                if(table.containsValue(Integer.toString(total))){
                    for(int j = 1; j < lineSplit.length; j++){
                        System.out.print(lineSplit[j] + " ");
                    }
                    for(String key : table.keySet()){
                        if(table.get(key).equals(Integer.toString(total))){
                            System.out.println(key);
                            break;
                        }
                    }
                }
                else{
                    for(int j = 1; j < lineSplit.length; j++){
                        System.out.print(lineSplit[j] + " ");
                    }
                    System.out.println("unknown");
                }
            }

            if(lineSplit[0].equals("clear"))
                table.clear();
        }
    }
}