import java.util.Scanner;
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        char[] texten = text.toCharArray();
        int days = 0;
        for(int i = 0; i < texten.length; i++){
            if(i % 3 == 0 && texten[i] != 'P'){
                texten[i] = 'P';
                days++;
            }
            if(i % 3 == 1 && texten[i] != 'E'){
                texten[i] = 'E';
                days++;
            }
            if(i % 3 == 2 && texten[i] != 'R'){
                texten[i] = 'R';
                days++;
            }
        }
        System.out.println(days);
    }
}