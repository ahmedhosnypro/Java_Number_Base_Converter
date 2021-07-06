import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int num = 1;
        while (num * num <= input){
            System.out.println(num * num);
            num++;
        }
    }
}