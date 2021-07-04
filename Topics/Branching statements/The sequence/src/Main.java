import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int i = 1;
        int j = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Outer:
        while (true) {
            int k = 0;
            while (true) {
                System.out.print(i + " ");
                j++;
                if (j == n)
                    break Outer;
                k++;
                if (k == i)
                    break;
            }
            i++;
        }
    }
}