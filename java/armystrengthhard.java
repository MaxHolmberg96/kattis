import java.io.*;

public class main {


    public static void main(String[] args) throws IOException {
        BufferedInputStream in = new BufferedInputStream(System.in);
        int cases = readInt(in);


        for (int c = 0; c < cases; c++) {
            int Godzilla = readInt(in);
            int MechaGodzilla = readInt(in);
            int stronkestAlly = 0;
            for (int i = 0; i < Godzilla; i++) {
                int scanint = readInt(in);
                if (scanint > stronkestAlly)
                    stronkestAlly = scanint;
                if (stronkestAlly == 1000000000)
                    break;
            }
            int stronkestHorde = 0;
            for (int i = 0; i < MechaGodzilla; i++) {
                int scanint = readInt(in);
                if (scanint > stronkestHorde)
                    stronkestHorde = scanint;
                if (stronkestHorde == 1000000000)
                    break;
            }


            if (stronkestAlly >= stronkestHorde)
                System.out.println("Godzilla");
            else if (stronkestAlly < stronkestHorde)
                System.out.println("MechaGodzilla");
            else
                System.out.println("uncertain");
        }
    }
    
    private static int readInt(InputStream in) throws IOException {
        int ret = 0;
        boolean dig = false;

        for (int c = 0; (c = in.read()) != -1; ) {
            if (c >= '0' && c <= '9') {
                dig = true;
                ret = ret * 10 + c - '0';
            } else if (dig) break;
        }

        return ret;
    }



}
