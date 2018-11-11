import java.util.Scanner;

public class printingcosts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            int cost = 0;
            for (int i = 0; i < s.length(); i++) {
                cost += cost(s.charAt(i));
            }
            System.out.println(cost);
        }
    }

    private static int cost(char c){
        switch(c){
            case ' ': return 0;

            case '!': return 9;

            case '"': return 6;

            case '#': return 24;

            case '$': return 29;

            case '%': return 22;

            case '&': return 24;

            case '\'': return 3;

            case '(': return 12;

            case ')': return 12;

            case '*': return 17;

            case '+': return 13;

            case ',': return 7;

            case '-': return 7;

            case '.': return 4;

            case '/': return 10;

            case '0': return 22;

            case '1': return 19;

            case '2': return 22;

            case '3': return 23;

            case '4': return 21;

            case '5': return 27;

            case '6': return 26;

            case '7': return 16;

            case '8': return 23;

            case '9': return 26;

            case ':': return 8;

            case ';': return 11;

            case '<': return 10;

            case '=': return 14;

            case '>': return 10;

            case '?': return 15;

            case '@': return 32;

            case 'A': return 24;

            case 'B': return 29;

            case 'C': return 20;

            case 'D': return 26;

            case 'E': return 26;

            case 'F': return 20;

            case 'G': return 25;

            case 'H': return 25;

            case 'I': return 18;

            case 'J': return 18;

            case 'K': return 21;

            case 'L': return 16;

            case 'M': return 28;

            case 'N': return 25;

            case 'O': return 26;

            case 'P': return 23;

            case 'Q': return 31;

            case 'R': return 28;

            case 'S': return 25;

            case 'T': return 16;

            case 'U': return 23;

            case 'V': return 19;

            case 'W': return 26;

            case 'X': return 18;

            case 'Y': return 14;

            case 'Z': return 22;

            case '[': return 18;

            case '\\': return 10;

            case ']': return 18;

            case '^': return 7;

            case '_': return 8;

            case '`': return 3;

            case 'a': return 23;

            case 'b': return 25;

            case 'c': return 17;

            case 'd': return 25;

            case 'e': return 23;

            case 'f': return 18;

            case 'g': return 30;

            case 'h': return 21;

            case 'i': return 15;

            case 'j': return 20;

            case 'k': return 21;

            case 'l': return 16;

            case 'm': return 22;

            case 'n': return 18;

            case 'o': return 20;

            case 'p': return 25;

            case 'q': return 25;

            case 'r': return 13;

            case 's': return 21;

            case 't': return 17;

            case 'u': return 17;

            case 'v': return 13;

            case 'w': return 19;

            case 'x': return 13;

            case 'y': return 24;

            case 'z': return 19;

            case '{': return 18;

            case '|': return 12;

            case '}': return 18;

            case '~': return 9;


        }
        return 0;
    }
}