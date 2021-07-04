import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int prevAsc = input;
        int prevDesc = input;
        boolean asc = true;
        boolean desc = true;

        while (true){
            input = scanner.nextInt();
            if (input == 0){
                break;
            }
            if (input >= prevAsc){
                prevAsc = input;
            }
            else asc = false;

            if (input <= prevDesc){
                prevDesc = input;
            }
            else desc = false;
        }

        System.out.println(asc || desc);
    }
}