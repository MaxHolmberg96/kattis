import java.util.ArrayList;
import java.util.HashMap;

public class dunglish {

    private static HashMap<String, ArrayList<String>> correct;
    private static HashMap<String, ArrayList<String>> incorrect;

    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        katt.getLine();
        String[] sentence = katt.getLine().split(" ");
        int n = Integer.parseInt(katt.getLine());
        correct = new HashMap<>();
        incorrect = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = katt.getLine().split(" ");
            if(line[2].equals("correct")){
                if(correct.containsKey(line[0])){
                    correct.get(line[0]).add(line[1]);
                } else {
                    ArrayList<String> correctTranslations = new ArrayList<>();
                    correctTranslations.add(line[1]);
                    correct.put(line[0], correctTranslations);
                }
            } else {
                if(incorrect.containsKey(line[0])){
                    incorrect.get(line[0]).add(line[1]);
                } else {
                    ArrayList<String> incorrectTranslations = new ArrayList<>();
                    incorrectTranslations.add(line[1]);
                    incorrect.put(line[0], incorrectTranslations);
                }
            }
        }
        long totalV = 1;
        long correctV = 1;
        long incorrectV;
        for (int i = 0; i < sentence.length; i++) {
            int correctSize = 0;
            int incorrectSize = 0;
            if(correct.containsKey(sentence[i])){
                correctSize = correct.get(sentence[i]).size();
            }
            if(incorrect.containsKey(sentence[i])){
                incorrectSize = incorrect.get(sentence[i]).size();
            }
            correctV *= correctSize;
            totalV *= correctSize+incorrectSize;
        }
        incorrectV = totalV - correctV;
        if(totalV == 1){
            boolean correctB = true;
            for (int i = 0; i < sentence.length; i++) {
                if(correct.containsKey(sentence[i])){
                    System.out.print(correct.get(sentence[i]).get(0) + " ");
                } else {
                    System.out.print(incorrect.get(sentence[i]).get(0) +  " ");
                    correctB = false;
                }
            }
            System.out.println(correctB ? "\ncorrect" : "\nincorrect");
        } else {
            System.out.println(correctV + " correct");
            System.out.println(incorrectV + " incorrect");
        }
    }

    private static Translation getTranslation(String word,
                                              ArrayList<Translation>
                                              translations){
        for (int i = 0; i < translations.size(); i++) {
            if(translations.get(i).dutch.equals(word)){
                return translations.get(i);
            }
        }
        return null;
    }

    private static int containsTranslation(String word,
                                               ArrayList<Translation>
                                               translations){
        for (int i = 0; i < translations.size(); i++) {
            if(translations.get(i).dutch.equals(word)){
                return i;
            }
        }
        return -1;
    }

    private static class Translation{
        String dutch;
        ArrayList<String> correctTranslations;
        ArrayList<String> incorrectTranslations;

        public Translation(String dutch) {
            this.dutch = dutch;
            correctTranslations = new ArrayList<>();
            incorrectTranslations = new ArrayList<>();
        }
    }
}
