import java.util.Scanner;
public class main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int L = scan.nextInt();
        int D = scan.nextInt();
        int X = scan.nextInt();
        int firstOutput = 1;
        int secondOutput = 1;
        for(int i = L; i <= D; i++){
            if(sumDigits(i) == X){
                firstOutput = i;
                break;
            }
        }

        for(int i = D; i >= L; i--){
            if(sumDigits(i) == X) {
                secondOutput = i;
                break;
            }
        }
        System.out.println(firstOutput);
        System.out.println(secondOutput);
    }



    public static long sumDigits(long i) {
        return i == 0 ? 0 : i % 10 + sumDigits(i / 10);
    }
}
