import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String strStartingAmount = scanner.nextLine();
        String strInterestRate = scanner.nextLine();
        int years = Integer.parseInt(scanner.nextLine());

        BigDecimal startingAmount = new BigDecimal(strStartingAmount);
        BigDecimal interestRate = new BigDecimal(strInterestRate);


        BigDecimal bigDecimal = (BigDecimal.ONE)
                .add(interestRate.divide(BigDecimal.valueOf(100)));

        BigDecimal finalAmount = startingAmount.multiply(bigDecimal.pow(years));
        BigDecimal rounded = finalAmount.setScale(2, RoundingMode.CEILING);
        System.out.println("Amount of money in the account: " + rounded);
    }
}