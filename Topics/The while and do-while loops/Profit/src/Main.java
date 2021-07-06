import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        double M = scanner.nextDouble();
        double P = scanner.nextDouble();
        double K = scanner.nextDouble();
        int year = 0;
        while (M < K){
            M += M * P / 100;
            year++;
        }
        System.out.println(year);
    }
}