import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String attacks = scan.nextLine();
        char[] s = new char[1000000];
        int b = 0;
        boolean enter = true;
        for (int i = 0; i < attacks.length(); i++) {
            if(i+2 < attacks.length()){
                if(attacks.charAt(i) == 'R'){
                    if(attacks.charAt(i+1) == 'B'){
                        if(attacks.charAt(i+2) == 'L') {
                            s[b] = 'C';
                            b++;
                            i+=2;
                            enter = false;
                        }
                    }
                    else if(attacks.charAt(i+1) == 'L') {
                        if(attacks.charAt(i+2) == 'B'){
                            s[b] = 'C';
                            b++;
                            i+=2;
                            enter = false;
                        }
                    }
                }


                else if(attacks.charAt(i) == 'B'){
                    if(attacks.charAt(i+1) == 'R'){
                        if(attacks.charAt(i+2) == 'L') {
                            s[b] = 'C';
                            b++;
                            i+=2;
                            enter = false;
                        }
                    }
                    else if(attacks.charAt(i+1) == 'L') {
                        if(attacks.charAt(i+2) == 'R'){
                            s[b] = 'C';
                            b++;
                            i+=2;
                            enter = false;
                        }
                    }
                }

                else if(attacks.charAt(i) == 'L'){
                    if(attacks.charAt(i+1) == 'R'){
                        if(attacks.charAt(i+2) == 'B') {
                            s[b] = 'C';
                            b++;
                            i+=2;
                            enter = false;
                        }
                    }
                    else if(attacks.charAt(i+1) == 'B') {
                        if(attacks.charAt(i+2) == 'R'){
                            s[b] = 'C';
                            b++;
                            i+=2;
                            enter = false;
                        }
                    }
                }
            }
            if(attacks.charAt(i) == 'R' && enter){
                s[b] = 'S';
                b++;
            }
            if(attacks.charAt(i) == 'B' && enter){
                s[b] = 'K';
                b++;
            }
            if(attacks.charAt(i) == 'L' && enter){
                s[b] = 'H';
                b++;
            }
            enter = true;
        }
        System.out.println(s);
    }
}