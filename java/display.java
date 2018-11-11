import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    private static String[] clock;
    private static ArrayList<ArrayList<Character>> output = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 7; i++){
            output.add(new ArrayList<>());
            for(int j = 0; j < 29; j++){
                output.get(i).add(' ');
            }
        }
        loop:
        while(scan.hasNextLine()){
            String string = scan.nextLine();


            output.clear();


            for(int i = 0; i < 7; i++){
                output.add(new ArrayList<>());
                for(int j = 0; j < 29; j++){
                    output.get(i).add(' ');
                }
            }


            if(string.equals("end")){
                System.out.println("end");
                break loop;
            }
            clock = string.split(":");
            switch(clock[0].charAt(0)){
                case '1':
                    writeone(0);
                    break;
                case '2':
                    writetwo(0);
                    break;
                case '3':
                    writethree(0);
                    break;
                case '4':
                    writefour(0);
                    break;
                case '5':
                    writefive(0);
                    break;
                case '6':
                    writesix(0);
                    break;
                case '7':
                    writeseven(0);
                    break;
                case '8':
                    writeeight(0);
                    break;
                case '9':
                    writenine(0);
                    break;
                case '0':
                    writezero(0);
                    break;
            }

            switch(clock[0].charAt(1)){
                case '1':
                    writeone(7);
                    break;
                case '2':
                    writetwo(7);
                    break;
                case '3':
                    writethree(7);
                    break;
                case '4':
                    writefour(7);
                    break;
                case '5':
                    writefive(7);
                    break;
                case '6':
                    writesix(7);
                    break;
                case '7':
                    writeseven(7);
                    break;
                case '8':
                    writeeight(7);
                    break;
                case '9':
                    writenine(7);
                    break;
                case '0':
                    writezero(7);
                    break;
            }


            switch(clock[1].charAt(0)){
                case '1':
                    writeone(17);
                    break;
                case '2':
                    writetwo(17);
                    break;
                case '3':
                    writethree(17);
                    break;
                case '4':
                    writefour(17);
                    break;
                case '5':
                    writefive(17);
                    break;
                case '6':
                    writesix(17);
                    break;
                case '7':
                    writeseven(17);
                    break;
                case '8':
                    writeeight(17);
                    break;
                case '9':
                    writenine(17);
                    break;
                case '0':
                    writezero(17);
                    break;
            }


            switch(clock[1].charAt(1)){
                case '1':
                    writeone(24);
                    break;
                case '2':
                    writetwo(24);
                    break;
                case '3':
                    writethree(24);
                    break;
                case '4':
                    writefour(24);
                    break;
                case '5':
                    writefive(24);
                    break;
                case '6':
                    writesix(24);
                    break;
                case '7':
                    writeseven(24);
                    break;
                case '8':
                    writeeight(24);
                    break;
                case '9':
                    writenine(24);
                    break;
                case '0':
                    writezero(24);
                    break;
            }

            output.get(2).remove(14);
            output.get(2).add(14, 'o');

            output.get(4).remove(14);
            output.get(4).add(14, 'o');
            printClock();
            System.out.println();
            System.out.println();
        }




    }
    public static void printClock(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 29; j++){
                System.out.print(output.get(i).get(j));
            }
            System.out.println();
        }
    }


    public static void writezero(int i){
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(1).remove(i+4);
        output.get(1).add(i+4, '|');

        output.get(2).remove(i+4);
        output.get(2).add(i+4, '|');

        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');

        output.get(4).remove(i+4);
        output.get(4).add(i+4, '|');

        output.get(5).remove(i+4);
        output.get(5).add(i+4, '|');

        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');

        output.get(0).remove(i);
        output.get(0).add(i, '+');
        output.get(0).remove(i+1);
        output.get(0).add(i+1, '-');
        output.get(0).remove(i+2);
        output.get(0).add(i+2, '-');
        output.get(0).remove(i+3);
        output.get(0).add(i+3, '-');
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(6).remove(i);
        output.get(6).add(i, '+');
        output.get(6).remove(i+1);
        output.get(6).add(i+1, '-');
        output.get(6).remove(i+2);
        output.get(6).add(i+2, '-');
        output.get(6).remove(i+3);
        output.get(6).add(i+3, '-');
        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');


        output.get(0).remove(i);
        output.get(0).add(i, '+');

        output.get(1).remove(i);
        output.get(1).add(i, '|');

        output.get(2).remove(i);
        output.get(2).add(i, '|');

        output.get(3).remove(i);
        output.get(3).add(i, '+');

        output.get(4).remove(i);
        output.get(4).add(i, '|');

        output.get(5).remove(i);
        output.get(5).add(i, '|');

        output.get(6).remove(i);
        output.get(6).add(i, '+');




    }




    public static void writeone(int i){

        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(1).remove(i+4);
        output.get(1).add(i+4, '|');

        output.get(2).remove(i+4);
        output.get(2).add(i+4, '|');

        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');

        output.get(4).remove(i+4);
        output.get(4).add(i+4, '|');

        output.get(5).remove(i+4);
        output.get(5).add(i+4, '|');

        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');

    }

    public static void writetwo(int i){

        output.get(0).remove(i);
        output.get(0).add(i, '+');
        output.get(0).remove(i+1);
        output.get(0).add(i+1, '-');
        output.get(0).remove(i+2);
        output.get(0).add(i+2, '-');
        output.get(0).remove(i+3);
        output.get(0).add(i+3, '-');
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(1).remove(i+4);
        output.get(1).add(i+4, '|');

        output.get(2).remove(i+4);
        output.get(2).add(i+4, '|');

        output.get(3).remove(i);
        output.get(3).add(i, '+');
        output.get(3).remove(i+1);
        output.get(3).add(i+1, '-');
        output.get(3).remove(i+2);
        output.get(3).add(i+2, '-');
        output.get(3).remove(i+3);
        output.get(3).add(i+3, '-');
        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');

        output.get(4).remove(i);
        output.get(4).add(i, '|');

        output.get(5).remove(i);
        output.get(5).add(i, '|');

        output.get(6).remove(i);
        output.get(6).add(i, '+');
        output.get(6).remove(i+1);
        output.get(6).add(i+1, '-');
        output.get(6).remove(i+2);
        output.get(6).add(i+2, '-');
        output.get(6).remove(i+3);
        output.get(6).add(i+3, '-');
        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');
    }


    public static void writethree(int i){

        output.get(0).remove(i);
        output.get(0).add(i, '+');
        output.get(0).remove(i+1);
        output.get(0).add(i+1, '-');
        output.get(0).remove(i+2);
        output.get(0).add(i+2, '-');
        output.get(0).remove(i+3);
        output.get(0).add(i+3, '-');
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(1).remove(i+4);
        output.get(1).add(i+4, '|');

        output.get(2).remove(i+4);
        output.get(2).add(i+4, '|');

        output.get(3).remove(i);
        output.get(3).add(i, '+');
        output.get(3).remove(i+1);
        output.get(3).add(i+1, '-');
        output.get(3).remove(i+2);
        output.get(3).add(i+2, '-');
        output.get(3).remove(i+3);
        output.get(3).add(i+3, '-');
        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');

        output.get(4).remove(i+4);
        output.get(4).add(i+4, '|');

        output.get(5).remove(i+4);
        output.get(5).add(i+4, '|');

        output.get(6).remove(i);
        output.get(6).add(i, '+');
        output.get(6).remove(i+1);
        output.get(6).add(i+1, '-');
        output.get(6).remove(i+2);
        output.get(6).add(i+2, '-');
        output.get(6).remove(i+3);
        output.get(6).add(i+3, '-');
        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');
    }

    public static void writefour(int i){

        output.get(0).remove(i);
        output.get(0).add(i, '+');
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(1).remove(i);
        output.get(1).add(i, '|');
        output.get(1).remove(i+4);
        output.get(1).add(i+4, '|');

        output.get(2).remove(i);
        output.get(2).add(i, '|');
        output.get(2).remove(i+4);
        output.get(2).add(i+4, '|');

        output.get(3).remove(i);
        output.get(3).add(i, '+');
        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');


        output.get(3).remove(i);
        output.get(3).add(i, '+');
        output.get(3).remove(i+1);
        output.get(3).add(i+1, '-');
        output.get(3).remove(i+2);
        output.get(3).add(i+2, '-');
        output.get(3).remove(i+3);
        output.get(3).add(i+3, '-');
        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');


        output.get(4).remove(i+4);
        output.get(4).add(i+4, '|');

        output.get(5).remove(i+4);
        output.get(5).add(i+4, '|');

        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');

    }

    public static void writefive(int i){

        output.get(0).remove(i);
        output.get(0).add(i, '+');
        output.get(0).remove(i+1);
        output.get(0).add(i+1, '-');
        output.get(0).remove(i+2);
        output.get(0).add(i+2, '-');
        output.get(0).remove(i+3);
        output.get(0).add(i+3, '-');
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(1).remove(i);
        output.get(1).add(i, '|');

        output.get(2).remove(i);
        output.get(2).add(i, '|');

        output.get(3).remove(i);
        output.get(3).add(i, '+');
        output.get(3).remove(i+1);
        output.get(3).add(i+1, '-');
        output.get(3).remove(i+2);
        output.get(3).add(i+2, '-');
        output.get(3).remove(i+3);
        output.get(3).add(i+3, '-');
        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');

        output.get(4).remove(i+4);
        output.get(4).add(i+4, '|');

        output.get(5).remove(i+4);
        output.get(5).add(i+4, '|');

        output.get(6).remove(i);
        output.get(6).add(i, '+');
        output.get(6).remove(i+1);
        output.get(6).add(i+1, '-');
        output.get(6).remove(i+2);
        output.get(6).add(i+2, '-');
        output.get(6).remove(i+3);
        output.get(6).add(i+3, '-');
        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');
    }

    public static void writesix(int i){

        output.get(0).remove(i);
        output.get(0).add(i, '+');
        output.get(0).remove(i+1);
        output.get(0).add(i+1, '-');
        output.get(0).remove(i+2);
        output.get(0).add(i+2, '-');
        output.get(0).remove(i+3);
        output.get(0).add(i+3, '-');
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(0).remove(i);
        output.get(0).add(i, '+');

        output.get(1).remove(i);
        output.get(1).add(i, '|');

        output.get(2).remove(i);
        output.get(2).add(i, '|');

        output.get(3).remove(i);
        output.get(3).add(i, '+');

        output.get(4).remove(i);
        output.get(4).add(i, '|');

        output.get(5).remove(i);
        output.get(5).add(i, '|');

        output.get(6).remove(i);
        output.get(6).add(i, '+');


        output.get(3).remove(i);
        output.get(3).add(i, '+');
        output.get(3).remove(i+1);
        output.get(3).add(i+1, '-');
        output.get(3).remove(i+2);
        output.get(3).add(i+2, '-');
        output.get(3).remove(i+3);
        output.get(3).add(i+3, '-');
        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');

        output.get(4).remove(i+4);
        output.get(4).add(i+4, '|');

        output.get(5).remove(i+4);
        output.get(5).add(i+4, '|');

        output.get(6).remove(i);
        output.get(6).add(i, '+');
        output.get(6).remove(i+1);
        output.get(6).add(i+1, '-');
        output.get(6).remove(i+2);
        output.get(6).add(i+2, '-');
        output.get(6).remove(i+3);
        output.get(6).add(i+3, '-');
        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');
    }


    public static void writeseven(int i){
        output.get(0).remove(i);
        output.get(0).add(i, '+');
        output.get(0).remove(i+1);
        output.get(0).add(i+1, '-');
        output.get(0).remove(i+2);
        output.get(0).add(i+2, '-');
        output.get(0).remove(i+3);
        output.get(0).add(i+3, '-');
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');


        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(1).remove(i+4);
        output.get(1).add(i+4, '|');

        output.get(2).remove(i+4);
        output.get(2).add(i+4, '|');

        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');

        output.get(4).remove(i+4);
        output.get(4).add(i+4, '|');

        output.get(5).remove(i+4);
        output.get(5).add(i+4, '|');

        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');

    }




    public static void writeeight(int i){
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(1).remove(i+4);
        output.get(1).add(i+4, '|');

        output.get(2).remove(i+4);
        output.get(2).add(i+4, '|');

        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');

        output.get(4).remove(i+4);
        output.get(4).add(i+4, '|');

        output.get(5).remove(i+4);
        output.get(5).add(i+4, '|');

        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');

        output.get(0).remove(i);
        output.get(0).add(i, '+');
        output.get(0).remove(i+1);
        output.get(0).add(i+1, '-');
        output.get(0).remove(i+2);
        output.get(0).add(i+2, '-');
        output.get(0).remove(i+3);
        output.get(0).add(i+3, '-');
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(3).remove(i);
        output.get(3).add(i, '+');
        output.get(3).remove(i+1);
        output.get(3).add(i+1, '-');
        output.get(3).remove(i+2);
        output.get(3).add(i+2, '-');
        output.get(3).remove(i+3);
        output.get(3).add(i+3, '-');
        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');


        output.get(6).remove(i);
        output.get(6).add(i, '+');
        output.get(6).remove(i+1);
        output.get(6).add(i+1, '-');
        output.get(6).remove(i+2);
        output.get(6).add(i+2, '-');
        output.get(6).remove(i+3);
        output.get(6).add(i+3, '-');
        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');


        output.get(0).remove(i);
        output.get(0).add(i, '+');

        output.get(1).remove(i);
        output.get(1).add(i, '|');

        output.get(2).remove(i);
        output.get(2).add(i, '|');

        output.get(3).remove(i);
        output.get(3).add(i, '+');

        output.get(4).remove(i);
        output.get(4).add(i, '|');

        output.get(5).remove(i);
        output.get(5).add(i, '|');

        output.get(6).remove(i);
        output.get(6).add(i, '+');




    }

    public static void writenine(int i){
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(1).remove(i+4);
        output.get(1).add(i+4, '|');

        output.get(2).remove(i+4);
        output.get(2).add(i+4, '|');

        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');

        output.get(4).remove(i+4);
        output.get(4).add(i+4, '|');

        output.get(5).remove(i+4);
        output.get(5).add(i+4, '|');

        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');

        output.get(0).remove(i);
        output.get(0).add(i, '+');
        output.get(0).remove(i+1);
        output.get(0).add(i+1, '-');
        output.get(0).remove(i+2);
        output.get(0).add(i+2, '-');
        output.get(0).remove(i+3);
        output.get(0).add(i+3, '-');
        output.get(0).remove(i+4);
        output.get(0).add(i+4, '+');

        output.get(3).remove(i);
        output.get(3).add(i, '+');
        output.get(3).remove(i+1);
        output.get(3).add(i+1, '-');
        output.get(3).remove(i+2);
        output.get(3).add(i+2, '-');
        output.get(3).remove(i+3);
        output.get(3).add(i+3, '-');
        output.get(3).remove(i+4);
        output.get(3).add(i+4, '+');


        output.get(6).remove(i);
        output.get(6).add(i, '+');
        output.get(6).remove(i+1);
        output.get(6).add(i+1, '-');
        output.get(6).remove(i+2);
        output.get(6).add(i+2, '-');
        output.get(6).remove(i+3);
        output.get(6).add(i+3, '-');
        output.get(6).remove(i+4);
        output.get(6).add(i+4, '+');


        output.get(0).remove(i);
        output.get(0).add(i, '+');

        output.get(1).remove(i);
        output.get(1).add(i, '|');

        output.get(2).remove(i);
        output.get(2).add(i, '|');

        output.get(3).remove(i);
        output.get(3).add(i, '+');

    }







}
