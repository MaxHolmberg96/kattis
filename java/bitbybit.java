import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s;
        while(!(s = sc.nextLine()).equals("0")){
            int n = Integer.parseInt(s);
            char[] bits = new char[32];
            for (int i = 0; i < 32; i++) {
                bits[i] = '?';
            }
            for (int p = 0; p < n; p++) {
                s = sc.nextLine();
                switch(s.split(" ")[0]){
                    case "SET":
                        bits[Integer.parseInt(s.split(" ")[1])] = '1';
                        break;
                    case "CLEAR":
                        bits[Integer.parseInt(s.split(" ")[1])] = '0';
                        break;
                    case "OR":
                        char a = bits[Integer.parseInt(s.split(" ")[1])];
                        char b = bits[Integer.parseInt(s.split(" ")[2])];
                        if(a == '1' || b == '1'){
                            bits[Integer.parseInt(s.split(" ")[1])] = '1';
                            break;
                        }
                        if(a != '?' && b != '?'){
                            boolean i = a == '1';
                            boolean j = b == '1';
                            bits[Integer.parseInt(s.split(" ")[1])] = (i || j) ? '1' : '0';
                            break;
                        }
                        else{
                            bits[Integer.parseInt(s.split(" ")[1])] = '?';
                            break;
                        }

                    case "AND":
                        a = bits[Integer.parseInt(s.split(" ")[1])];
                        b = bits[Integer.parseInt(s.split(" ")[2])];
                        if(a == '0' || b == '0'){
                            bits[Integer.parseInt(s.split(" ")[1])] = '0';
                            break;
                        }
                        if(a != '?' && b != '?') {
                            boolean i = a == '1';
                            boolean j = b == '1';
                            bits[Integer.parseInt(s.split(" ")[1])] = (i && j) ? '1' : '0';
                            break;
                        }
                        else{
                            bits[Integer.parseInt(s.split(" ")[1])] = '?';
                            break;
                        }
                }
            }
            for (int i = 31; i >= 0; i--) {
                System.out.print(bits[i]);
            }
            System.out.println();
        }
    }
}