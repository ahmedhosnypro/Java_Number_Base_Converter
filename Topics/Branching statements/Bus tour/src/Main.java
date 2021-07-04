import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int busHight = scanner.nextInt();
        int bridgeNum = scanner.nextInt();
        boolean isCrash = false;
        for (int i = 1; i <= bridgeNum; i++) {
            int bridgeHight = scanner.nextInt();
            if (busHight >= bridgeHight) {
                System.out.println("Will crash on bridge " + i);
                isCrash = true;
                break;
            }
        }
        if (!isCrash) {
            System.out.println("Will not crash");
        }

    }
}
