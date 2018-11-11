import java.util.Scanner;
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] score = new int[5];
        for(int y = 0; y < 5; y++)
            for(int x = 0; x < 4; x++){
                score[y] = score[y] + scan.nextInt();
            }
        int highest = 0;
        for(int i = 0; i < 5; i++)
            if(highest < score[i])
                highest = score[i];
        for(int i = 0; i < 5; i++)
            if(highest == score[i])
                System.out.println(i+1 + " " + highest);
    }
}