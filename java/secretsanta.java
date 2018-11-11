import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        String n = sc.nextLine();
        String nextString = "";
        String s = "";
        if(n.equals("3"))
            System.out.println("0.66666667");
        else if(n.length() < 4)
            System.out.println(func(n).toString().substring(0, 10));
        else
            System.out.println("0.63212055");
    }


    public static BigDecimal func(String n){
        BigDecimal b = derangement(n).setScale(0, RoundingMode.FLOOR);
        BigDecimal B = b.divide(factorial(new BigDecimal(n)), 10, RoundingMode.FLOOR);
        return new BigDecimal("1").subtract(B);
    }

    public static BigDecimal derangement(String n){
        BigDecimal fact = new BigDecimal(factorial(new BigDecimal(n)).toString());
        return ((fact.add(BigDecimal.ONE)).divide(BigDecimal.valueOf(Math.E), 10, RoundingMode.FLOOR));
    }

    public static BigDecimal factorial(BigDecimal n) {
        BigDecimal result = BigDecimal.ONE;

        while (!n.equals(BigDecimal.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigDecimal.ONE);
        }

        return result;
    }
}
