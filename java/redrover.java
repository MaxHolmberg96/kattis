import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class redrover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<String> subStrings = new ArrayList<>();
        HashSet<String> duplicates = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+2; j <= s.length(); j++) {
                String a = s.substring(i, j);
                if(!duplicates.contains(a)){
                    subStrings.add(a);
                    duplicates.add(a);
                }
            }
        }
        int minimalCharacters = Integer.MAX_VALUE;
        for (int i = 0; i < subStrings.size(); i++) {
            int occureces = countOccurence(subStrings.get(i), s);
            int charLeftInString = s.length()-occureces*subStrings.get(i).length();
            int min = charLeftInString+occureces+subStrings.get(i).length();
            if(min < minimalCharacters){
                minimalCharacters = min;
            }
        }
        if(subStrings.size() == 0 || minimalCharacters > s.length()){
            System.out.println(s.length());
        } else {
            System.out.println(minimalCharacters);
        }
    }

    private static int countOccurence(String sub, String s){
        int c = 0;
        int p = 0;
        while(!false) {
            p = s.indexOf(sub, p);
            if(p == -1){
                break;
            }
            p+=sub.length();
            c++;
        }
        return c;
    }

}