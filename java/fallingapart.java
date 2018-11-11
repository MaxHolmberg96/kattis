import java.util.Arrays;

public class fallingapart {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        int n = katt.getInt();
        int[] pieces = new int[n];
        for (int i = 0; i < n; i++) {
            pieces[i] = katt.getInt();
        }
        Arrays.sort(pieces);
        int alice = 0;
        int bob = 0;
        boolean aliceTurn = true;
        for (int i = n-1; i >= 0; i--) {
            if(aliceTurn){
                alice += pieces[i];
                aliceTurn = false;
            } else {
                bob += pieces[i];
                aliceTurn = true;
            }
        }
        System.out.println(alice + " " + bob);
    }
}
