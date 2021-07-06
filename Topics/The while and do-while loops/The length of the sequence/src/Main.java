import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while (true) {
            int n = scanner.nextInt();
            if (n==0)
                break;
            else numbers.add(n);
        }
        System.out.println(numbers.size());
    }
}