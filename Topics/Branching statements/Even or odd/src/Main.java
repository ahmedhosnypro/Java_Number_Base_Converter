import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int i = scanner.nextInt();
            if (i == 0){
                break;
            }
            else if (i % 2 == 0){
                System.out.println("even");
            }
            else {
                System.out.println("odd");
            }
        }
    }
}