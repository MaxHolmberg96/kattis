
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static char[][] sky;
    public static int rows;
    public static int columns;

    public static void main(String[] args) throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        int caseCounter = 0;
        while(scan.hasNextLine()) {
            counter = 0;
            rows = scan.nextInt();
            columns = scan.nextInt();
            scan.nextLine();
            sky = new char[rows][columns];
            for(int y = 0; y < rows; y++) {
                String input = scan.nextLine();
                for (int x = 0; x < columns; x++) {
                    sky[y][x] = input.charAt(x);
                }
            }
            for(int y = 0; y < rows; y++){
                for(int x = 0; x < columns; x++){
                    if(fill(x, y))
                        counter++;
                }

            }
            caseCounter++;
            System.out.println("Case " + caseCounter + ": " + counter);

        }


    }

    public static boolean fill(int x, int y)throws InterruptedException{
        if(sky[y][x] == '-'){
            sky[y][x] = '#';
            if(y < rows && y >= 0 && x >= 0 && x < columns-1)
                if(sky[y][x+1] == '-'){
                    fill(x+1, y);
                }
            if(y < rows && y >= 0 && x > 0 && x < columns)
                if(sky[y][x-1] == '-'){
                    fill(x-1, y);
                }
            if(y < rows-1 && y >= 0 && x >= 0 && x < columns)
                if(sky[y+1][x] == '-'){
                    fill(x, y+1);
                }
            if(y < rows && y > 0 && x >= 0 && x < columns)
                if(sky[y-1][x] == '-'){
                    fill(x, y-1);
                }
            return true;
        }
        return false;
    }


    public static void print() throws InterruptedException {
        for(int y = 0; y < rows; y++){
            for(int x = 0; x < columns; x++){
                System.out.print(sky[y][x]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

}


