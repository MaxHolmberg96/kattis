import java.util.ArrayList;

public class asciiaddition {
    private static final int LENGTH = 5;

    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        char[][] input = new char[7][];
        for (int i = 0; i < 7; i++) {
            String s = katt.getLine();
            input[i] = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                input[i][j] = s.charAt(j);
            }
        }
        ArrayList<Integer> ints = new ArrayList<>();
        int k = 0;
        int f1 = 0;
        for (int i = 0; i < input[0].length; i+=6) {
            ints.add(checkDigit(i, input));
            if(ints.get(k) == -1){f1 = k;}
            k++;
        }
        int f2 = (ints.size()-1)-f1, sum1 = 0, sum2 = 0, tmp1 = f1, tmp2 = f2;
        for (int i = 0; i < f1; i++) {sum1 += ints.get(i)*Math.pow(10, tmp1-=1);}
        for (int i = f1+1; i < ints.size(); i++) {sum2 += ints.get(i)*Math.pow(10, tmp2-=1);}
        int total = sum1+sum2;
        int nrDigits = (int) (Math.log10(total)+1), index = 0;
        int totalLengthOuput = (nrDigits*5)+nrDigits;
        char[][] output = new char[7][totalLengthOuput];
        String s = String.valueOf(total);
        for (int i = 0; i < s.length(); i++) {
            index = i*6;
            if(i > 0) fill(index-1, output);
            convert(index, output, s.charAt(i)-48);
        }
        for (int i = 0; i < output.length; i++) { for (int j = 0; j < output[i].length; j++) { System.out.print(output[i][j]); }System.out.println(); }
    }

    private static int checkDigit(int i, char[][] input){
        if(input[3][i+2] == '.' && input[3][i] == 'x') return 0;
        if(input[5][i] == '.' && input[1][i+4] == 'x' && input[2][i] == 'x' && input[0][i+2] == 'x') return 9;
        if(input[1][i] == 'x' && input[1][i+4] == 'x' && input[5][i] == 'x') return 8;
        if(input[2][i+2] == 'x') return -1;
        if(input[0][i+2] == 'x' && input[6][i+1] == '.') return 7;
        if(input[5][i] == 'x' && input[5][i+4] == 'x' && input[1][i+4] == '.') return 6;
        if(input[0][i+2] == 'x' && input[1][i+4] == '.' && input[6][i+2] == 'x') return 5;
        if(input[0][i+2] == '.' && input[0][i] == 'x') return 4;
        if(input[0][i+2] == 'x' && input[5][i+4] == 'x') return 3;
        if(input[0][i] == 'x') return 2;
        return 1;
    }

    private static void fill(int i, char[][] output){
        for (int j = 0; j < 7; j++) { output[j][i] = '.'; }
    }

    private static void convert(int i, char[][] output, int n){
        switch (n){
            case 1:
                for (int j = 0; j < 7; j++) { for (int k = i; k < i+5; k++) { output[j][k] = '.'; } }
                for (int j = 0; j < 7; j++) { output[j][i+4] = 'x'; }
                break;
            case 2:
                for (int j = 0; j < 7; j++) { for (int k = i; k < i+5; k++) { output[j][k] = '.'; } }
                for (int j = 0; j < 7; j+=3) { for (int k = i; k < i+5; k++) { output[j][k] = 'x'; } }
                for (int j = 0; j < 7; j++) { if(j < 3){ output[j][i+4] = 'x'; } else {output[j][i] = 'x';}}
                break;
            case 3:
                for (int j = 0; j < 7; j++) { for (int k = i; k < i+5; k++) { output[j][k] = '.'; } }
                for (int j = 0; j < 7; j+=3) { for (int k = i; k < i+5; k++) { output[j][k] = 'x'; } }
                for (int j = 0; j < 7; j++) { output[j][i+4] = 'x'; }
                break;
            case 4:
                for (int j = 0; j < 7; j++) { for (int k = i; k < i+5; k++) { output[j][k] = '.'; } }
                for (int j = 0; j < 7; j++) { output[j][i+4] = 'x'; if(j < 3) {output[j][i] = 'x';}}
                for (int j = i; j < i+5; j++) { output[3][j] = 'x'; }
                break;
            case 5:
                for (int j = 0; j < 7; j++) { for (int k = i; k < i+5; k++) { output[j][k] = '.'; } }
                for (int j = 0; j < 7; j+=3) { for (int k = i; k < i+5; k++) { output[j][k] = 'x'; } }
                for (int j = 0; j < 7; j++) { if(j < 3){ output[j][i] = 'x'; } else {output[j][i+4] = 'x';}}
                break;
            case 6:
                for (int j = 0; j < 7; j++) { for (int k = i; k < i+5; k++) { output[j][k] = '.'; } }
                for (int j = 0; j < 7; j+=3) { for (int k = i; k < i+5; k++) { output[j][k] = 'x'; } }
                for (int j = 0; j < 7; j++) { if(j < 3){ output[j][i] = 'x'; } else {output[j][i+4] = 'x'; output[j][i] = 'x';}}
                break;
            case 7:
                for (int j = 0; j < 7; j++) { for (int k = i; k < i+5; k++) { output[j][k] = '.'; } }
                for (int j = 0; j < 7; j++) { output[j][i+4] = 'x'; }
                for (int j = i; j < i+5; j++) { output[0][j] = 'x'; }
                break;
            case 8:
                for (int j = 0; j < 7; j++) { for (int k = i; k < i+5; k++) { output[j][k] = '.'; } }
                for (int j = 0; j < 7; j+=3) { for (int k = i; k < i+5; k++) { output[j][k] = 'x'; } }
                for (int j = 0; j < 7; j++) { output[j][i+4] = 'x'; output[j][i] = 'x';}
                break;
            case 9:
                for (int j = 0; j < 7; j++) { for (int k = i; k < i+5; k++) { output[j][k] = '.'; } }
                for (int j = 0; j < 7; j+=3) { for (int k = i; k < i+5; k++) { output[j][k] = 'x'; } }
                for (int j = 0; j < 7; j++) { if(j < 3){ output[j][i] = 'x';output[j][i+4] = 'x';} else {output[j][i+4] = 'x';}}
                break;
            case 0:
                for (int j = 0; j < 7; j++) { for (int k = i; k < i+5; k++) { output[j][k] = '.'; } }
                for (int j = 0; j < 7; j+=6) { for (int k = i; k < i+5; k++) { output[j][k] = 'x'; } }
                for (int j = 0; j < 7; j++) { output[j][i+4] = 'x'; output[j][i] = 'x';}
                break;
        }
    }
}
