import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int place = 1;

        while(scan.hasNextLine()){
            String moves = scan.nextLine();
            for(int i = 0; i < moves.length(); i++){
                if(moves.charAt(i) == 'A' && place == 1){
                    place = 2;
                }
                else if(moves.charAt(i) == 'A' && place == 2){
                    place = 1;
                }
                else if(moves.charAt(i) == 'B' && place == 2){
                    place = 3;
                }
                else if(moves.charAt(i) == 'B' && place == 3){
                    place = 2;
                }
                else if(moves.charAt(i) == 'C' && place == 1){
                    place = 3;
                }
                else if(moves.charAt(i) == 'C' && place == 3){
                    place = 1;
                }
            }
            System.out.println(place);
        }

    }
}
