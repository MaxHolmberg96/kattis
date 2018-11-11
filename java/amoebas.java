import java.util.Scanner;

public class amoebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        char[][] m = new char[N][M];
        for (int i = 0; i < N; i++) {
            m[i] = sc.nextLine().toCharArray();
        }
        int c = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if(flood(m, i, j) == 1){
                    c++;
                }
            }
        }
        System.out.println(c);
    }

    private static int flood(char[][] m, int r, int c){
        if(!(r < m.length && r >= 0 && c < m[r].length && c >= 0)){
            return 0;
        } else if(m[r][c] == '.'){
            return -1;
        } else {
            if(r < m.length && r >= 0 && c < m[r].length && c >= 0){
                m[r][c] = '.';
                flood(m, r-1, c-1);
                flood(m, r-1, c+1);
                flood(m, r+1, c-1);
                flood(m, r+1, c+1);

                flood(m, r-1, c);
                flood(m, r+1, c);
                flood(m, r, c-1);
                flood(m, r, c+1);
            } else {
                return 0;
            }
        }
        return 1;
    }
}