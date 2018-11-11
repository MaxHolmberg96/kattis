
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> chess = new ArrayList<>();
        boolean valid = true;
        for(int i = 0; i < 8; i++){
            chess.add(i, scan.nextLine());
        }
        int counter = 0;
        loops:
        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                if(chess.get(y).charAt(x) == '*'){
                    for(int l = 0; l < 8; l++){
                        if(chess.get(y).charAt(l) == '*' && l != x){
                            valid = false;
                            break loops;
                        }
                    }
                    for(int c = 0; c < 8; c++){
                        if(chess.get(c).charAt(x) == '*' && c != y){
                            valid = false;
                            break loops;
                        }
                    }
                    int x2 = x;
                    int y2 = y;
                    for(; x2 < 8 && y2 < 8; x2++){
                        if(chess.get(y2).charAt(x2) == '*' && x2 != x){
                            valid = false;
                            break loops;
                        }
                        y2++;
                    }

                    x2 = x;
                    y2 = y;
                    for(; x2 > 0 && y2 < 8; x2--){
                        if(chess.get(y2).charAt(x2) == '*' && x2 != x){
                            valid = false;
                            break loops;
                        }
                        y2++;
                    }


                    x2 = x;
                    y2 = y;
                    for(; x2 > 0 && y2 > 0; x2--){
                        if(chess.get(y2).charAt(x2) == '*' && x2 != x){
                            valid = false;
                            break loops;
                        }
                        y2--;
                    }

                    x2 = x;
                    y2 = y;
                    for(; x2 < 8 && y2 > 0; x2++){
                        if(chess.get(y2).charAt(x2) == '*' && x2 != x){
                            valid = false;
                            break loops;
                        }
                        y2--;
                    }
                    counter++;
                }
            }
        }

        if(valid && counter == 8)
              System.out.println("valid");
        else
            System.out.println("invalid");
    }
}
