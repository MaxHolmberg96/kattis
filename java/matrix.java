
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = new int[2][2];
        int counter = 0;
        while(scan.hasNextLine()) {
            String string = scan.nextLine();
            String[] split = string.split(" ");

            matrix[0][0] = Integer.parseInt(split[0]);
            matrix[0][1] = Integer.parseInt(split[1]);

            string = scan.nextLine();
            split = string.split(" ");

            matrix[1][0] = Integer.parseInt(split[0]);
            matrix[1][1] = Integer.parseInt(split[1]);

            counter++;
            //inverse
            int[][] inverse = new int[2][2];
            inverse[0][0] = matrix[1][1];
            inverse[0][1] = -matrix[0][1];
            inverse[1][0] = -matrix[1][0];
            inverse[1][1] = matrix[0][0];
            if(((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0])) != 0) {
                inverse[0][0] = inverse[0][0] / ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
                inverse[0][1] = inverse[0][1] / ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
                inverse[1][0] = inverse[1][0] / ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
                inverse[1][1] = inverse[1][1] / ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            }
            else{
                inverse[0][0] = 0;
                inverse[0][1] = 0;
                inverse[1][0] = 0;
                inverse[1][1] = 0;
            }

            System.out.println("Case " + counter + ":");
            System.out.print(inverse[0][0]);
            System.out.print(" ");
            System.out.print(inverse[0][1]);
            System.out.println();
            System.out.print(inverse[1][0]);
            System.out.print(" ");
            System.out.println(inverse[1][1]);
            scan.nextLine();

        }


    }
}


