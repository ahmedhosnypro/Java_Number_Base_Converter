import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        int i = 1;
        while (true){
            long result = factorial(i);
            if (result > input){
                break;
            }
            i++;
        }
        System.out.println(i);
    }
    public static long factorial(long n) {
        if (n == 0 || n == 1) {
            return 1; // the trivial case
        } else {
            return n * factorial(n - 1); // the recursive call
        }
    }
}