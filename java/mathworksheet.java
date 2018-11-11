import java.io.*;
import java.util.*;

public class main {

    private static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int cases;
        boolean first = true;
        while((cases = scan.nextInt()) != 0){
            scan.nextLine();
            if(!first)
                System.out.println();
            for(int i = 0; i < cases; i++){
                String[] split = scan.nextLine().split(" ");
                if(split[1].equals("+")){
                    int r = Integer.parseInt(split[0]) + Integer.parseInt(split[2]);
                    strings.add(Integer.toString(r));
                }
                if(split[1].equals("-")){
                    int r = Integer.parseInt(split[0]) - Integer.parseInt(split[2]);
                    strings.add(Integer.toString(r));
                }
                if(split[1].equals("*")){
                    int r = Integer.parseInt(split[0]) * Integer.parseInt(split[2]);
                    strings.add(Integer.toString(r));
                }

            }
            int big = biggestString();

            int length = 0;
            String line = "";
            for(int i = 0; i < strings.size(); i++){
                String tmp = strings.get(i);
                length += big + 1;

                if(i < strings.size()-1 && length + big > 50){
                    line += leftpad(tmp, big) + '\n';
                    length = 0;
                }
                else if(i != strings.size()-1){
                    line += leftpad(tmp, big) + ' ';
                }
                else if(i == strings.size()-1){
                    line += leftpad(tmp, big) + '\n';
                }
            }
            System.out.print(line);

            first = false;
            strings.clear();
        }
    }



    public static int biggestString(){
        int biggest = 0;
        for(int i = 0; i < strings.size(); i++){
            if(strings.get(i).length() > biggest)
                biggest = strings.get(i).length();
        }
        return biggest;
    }

    private static String leftpad(String text, int length) {
        return String.format("%" + length + "s", text);
    }
}


/*
     if(length <= 50 && i < strings.size()-1 && length + strings.get(i+1).length() <= 50){
                    tmp += ' ';
                    strings.remove(i);
                    strings.add(i, tmp);
                    length++;
                }
                else if(i < strings.size()-1 && length + strings.get(i+1).length() > 50 || i == strings.size()-1){
                    tmp += '\n';
                    strings.remove(i);
                    strings.add(i, tmp);
                    length = 0;
                }
 */
