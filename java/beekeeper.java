import java.io.*;
import java.util.*;

public class main {
    private static ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int i = 0;
            for(int cases = scan.nextInt(); i < cases && cases != 0; i++){
                if(i == 0)
                    scan.nextLine();
                words.add(scan.nextLine());
            }
            if(i == 0)
                break;
            ArrayList<String> cpy = (ArrayList)words.clone();
            replaceVowels();
            System.out.println(cpy.get(mostCountPairs()));
            words.clear();
        }
    }


    private static void replaceVowels(){
        for(int i = 0; i < words.size(); i++) {
            String tmp = words.get(i);
            tmp = tmp.replaceAll("([aeiouy])\\1+", "1");
            words.remove(i);
            words.add(i, tmp);
        }
    }

    private static int mostCountPairs(){
        int counter = 0;
        int highest = 0;
        for(int i = 0; i < words.size(); i++){
            String tmp = words.get(i);
            for(int j = 0; j < tmp.length(); j++){
                if(tmp.charAt(j) == '1')
                    counter++;
            }
            if(counter > highest)
                highest = counter;
            counter = 0;
        }
        counter = 0;
        for(int i = 0; i < words.size(); i++){
            String tmp = words.get(i);
            for(int j = 0; j < tmp.length(); j++){
                if(tmp.charAt(j) == '1')
                    counter++;
            }
            if(counter == highest)
                return i;
            counter = 0;
        }
        return 0;
    }
}