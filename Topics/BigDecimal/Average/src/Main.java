import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String strN1 = scanner.nextLine();
        String strN2 = scanner.nextLine();
        String strN3 = scanner.nextLine();

        BigDecimal n1 = new BigDecimal(strN1);
        BigDecimal n2 = new BigDecimal(strN2);
        BigDecimal n3 = new BigDecimal(strN3);

        BigDecimal sum = n1.add(n2).add(n3);
        BigDecimal avg = sum.divide(BigDecimal.valueOf(3), 0, RoundingMode.HALF_EVEN);
        System.out.println(avg);
    }
}