import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = 1001;
        int min = 0;
        int index = 500;

        System.out.println(index);
        for(int i = 0; i < 10; i ++){
            String input = scan.nextLine();
            if(input.equals("correct"))
                break;
            if(input.equals("lower")){
               max = index;
               index = max - ((max-min)/2);
               System.out.println(index);
            }
            if(input.equals("higher")){
                min = index;
                index = min + ((max-min)/2);
                System.out.println(index);

            }
        }
    }
}
