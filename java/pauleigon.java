import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int serves = scan.nextInt();
        int paulScore = scan.nextInt();
        int opponentScore = scan.nextInt();
        int servesTot = serves * 2;
        if(((paulScore + opponentScore) / serves) % 2 == 0)
            System.out.println("paul");
        else {
            System.out.println("opponent");
        }
    }
}

