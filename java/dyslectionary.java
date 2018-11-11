import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    private static ArrayList<String> words = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner katt = new Scanner(System.in);
        
        String line;
        while(katt.hasNextLine()){
            line = katt.nextLine();
            if(line.equals("")){
                sort();
                leftPad();
                for (String s : words)
                    System.out.println(s);
                words.clear();
                System.out.println();
            }
            else{
                words.add(line);
            }
        }
        sort();
        leftPad();
        for(int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }


    private static void leftPad(){
        int padLength = maxLength();
        for(int j = 0; j < words.size(); j++){
            String tmp = words.get(j);
            for(int i = words.get(j).length(); i < padLength; i++){
                tmp = " " + tmp;
            }
            words.remove(j);
            words.add(j, tmp);
        }
    }

    private static void sort(){
        Collections.sort(words, (o1, o2) -> {
            for(int i = 1; o1.length()-i >= 0 && o2.length()-i >= 0; i++){
                if(o1.charAt(o1.length()-i) > o2.charAt(o2.length()-i)){
                    return 1;
                }
                else if(o1.charAt(o1.length()-i) < o2.charAt(o2.length()-i)){
                    return -1;
                }
            }
            if(o1.length() < o2.length())
                return -1;
            else if(o1.length() > o2.length())
                return 1;
            else
                return 0;
        });

    }

    private static int maxLength(){
        int maxLength = 0;
        for(String s : words)
            if(maxLength < s.length())
                maxLength = s.length();
        return maxLength;
    }
}
