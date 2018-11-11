import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String adrian = "ABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABCABC";
        String bruno = "BABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABCBABC";
        String goran = "CCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABBCCAABB";
        scan.nextLine();
        String subString = scan.nextLine();
        int adrianScore = 0;
        int brunoScore = 0;
        int goranScore = 0;
        for(int i = 0; i < n; i++){
            //adrian
            adrianScore = 0;
            for(int j = 0; j < subString.length(); j++){
                if(subString.charAt(j) == adrian.charAt(j))
                    adrianScore++;
            }

            brunoScore = 0;
            for(int j = 0; j < subString.length(); j++){
                if(subString.charAt(j) == bruno.charAt(j))
                    brunoScore++;
            }

            goranScore = 0;
            for(int j = 0; j < subString.length(); j++){
                if(subString.charAt(j) == goran.charAt(j))
                    goranScore++;
            }
        }

        String[] names = {"Goran", "Adrian", "Bruno"};
        int[] score = {goranScore, adrianScore, brunoScore};
        int max = getMax(score);
        System.out.println(max);
        ArrayList<String> sort = new ArrayList<String>();
        int count = 0;
        for(int i = 0; i < 3; i++){
            if(score[i] == max){
                sort.add(names[i]);
                count++;
            }
        }

        Collections.sort(sort, String.CASE_INSENSITIVE_ORDER);
        for(int i = 0; i < sort.size(); i++)
            System.out.println(sort.get(i));

    }

    // Method for getting the maximum value
    public static int getMax(int[] inputArray){
        int maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }
}