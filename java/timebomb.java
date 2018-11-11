import java.util.Scanner;

public class timebomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[][] m = new char[5][s.length()];
        m[0] = s.toCharArray();
        for (int i = 1; i < 5; i++) {
            s = sc.nextLine();
            m[i] = s.toCharArray();
        }
        System.out.println(parse(m) % 6 == 0 ? "BEER!!" : "BOOM!!");
    }

    private static int parse(char[][] m){
        String number = "";
        for (int i = 0; i < m[0].length; i+=4) {
            int x = equals(i, m);
            if(x == -1){
                return -1;
            } else {
                number += x;
            }
        }
        return Integer.parseInt(number);
    }

    private static int equals(int i, char[][] m){
        int[] number = new int[10];
        for (int j = 0; j < 5; j++) {
            for (int k = i; k < i+3; k++) {
                if(zero[j][k-i] == m[j][k]) number[0]++;
                if(one[j][k-i] == m[j][k]) number[1]++;
                if(two[j][k-i] == m[j][k]) number[2]++;
                if(three[j][k-i] == m[j][k]) number[3]++;
                if(four[j][k-i] == m[j][k]) number[4]++;
                if(five[j][k-i] == m[j][k]) number[5]++;
                if(six[j][k-i] == m[j][k]) number[6]++;
                if(seven[j][k-i] == m[j][k]) number[7]++;
                if(eight[j][k-i] == m[j][k]) number[8]++;
                if(nine[j][k-i] == m[j][k]) number[9]++;
            }
        }
        for (int j = 0; j < number.length; j++) {
            if(number[j] == 15) return j;
        }
        return -1;
    }

    private static char[][] zero = new char[][]{
            {'*','*','*'},
            {'*',' ','*'},
            {'*',' ','*'},
            {'*',' ','*'},
            {'*','*','*'}
    };
    private static char[][] one = new char[][]{
            {' ',' ','*'},
            {' ',' ','*'},
            {' ',' ','*'},
            {' ',' ','*'},
            {' ',' ','*'}
    };
    private static char[][] two = new char[][]{
            {'*','*','*'},
            {' ',' ','*'},
            {'*','*','*'},
            {'*',' ',' '},
            {'*','*','*'}
    };
    private static char[][] three = new char[][]{
            {'*','*','*'},
            {' ',' ','*'},
            {'*','*','*'},
            {' ',' ','*'},
            {'*','*','*'}
    };
    private static char[][] four = new char[][]{
            {'*',' ','*'},
            {'*',' ','*'},
            {'*','*','*'},
            {' ',' ','*'},
            {' ',' ','*'}
    };
    private static char[][] five = new char[][]{
            {'*','*','*'},
            {'*',' ',' '},
            {'*','*','*'},
            {' ',' ','*'},
            {'*','*','*'}
    };
    private static char[][] six = new char[][]{
            {'*','*','*'},
            {'*',' ',' '},
            {'*','*','*'},
            {'*',' ','*'},
            {'*','*','*'}
    };
    private static char[][] seven = new char[][]{
            {'*','*','*'},
            {' ',' ','*'},
            {' ',' ','*'},
            {' ',' ','*'},
            {' ',' ','*'}
    };
    private static char[][] eight = new char[][]{
            {'*','*','*'},
            {'*',' ','*'},
            {'*','*','*'},
            {'*',' ','*'},
            {'*','*','*'}
    };
    private static char[][] nine = new char[][]{
            {'*','*','*'},
            {'*',' ','*'},
            {'*','*','*'},
            {' ',' ','*'},
            {'*','*','*'}
    };
}