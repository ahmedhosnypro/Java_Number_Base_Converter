import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String strN1 = scanner.nextLine();
        String strN2 = scanner.nextLine();

        BigDecimal n1 = new BigDecimal(strN1);
        BigDecimal n2 = new BigDecimal(strN2);

        BigDecimal multiply = n1.multiply(n2);
        System.out.println(multiply);
    }
}