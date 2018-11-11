import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class smallestmultiple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] line = sc.nextLine().split(" ");
            ArrayList<BigInteger> numbers = new ArrayList<>();
            for (int i = 0; i < line.length; i++) {
                numbers.add(new BigInteger(line[i]));
            }
            BigInteger result = numbers.get(0);
            for (int i = 1; i < numbers.size(); i++) {
                result = result.multiply(numbers.get(i)).divide(result.gcd(numbers.get(i)));
            }
            System.out.println(result);
        }
    }
}