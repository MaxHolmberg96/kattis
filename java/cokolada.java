import static java.lang.Math.*;

public class cokolada {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        int k = katt.getInt();
        int[] powers = new int[21];
        for (int i = 0; i < 21; i++) {
            powers[i] = (int)pow(2,i);
        }
        /* smallest distance */
        int smallest = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < 21; i++) {
            if(abs(k-powers[i]) < smallest){
                index = i;
                smallest = abs(k-powers[i]);
            }
        }
        int r = powers[index];
        int r2 = powers[index];
        if(r < k && index+1 < 21){
            r = powers[index+1];
        }
        if(k % 2 != 0){
            String binary = Integer.toBinaryString(r);
            int divbytwoCount = binary.length() - binary.replaceAll("0", "").length();
            System.out.println(r + " " + divbytwoCount);
        } else {
            if(k == r){
                System.out.println(k + " 0");
            } else {
                int sum = 0;
                int c = 0;
                int aux = r;
                while (true) {
                    sum += r/2;
                    if(sum > k){
                        sum -= r/2;
                    }
                    r = r/2;
                    c++;
                    if(sum == k){
                        System.out.println(aux + " " + c);
                        break;
                    }
                }
            }

        }
    }
}
