import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int result = 0;
        if (i % 4 == 0){
            result = i;
        }
        while(scanner.hasNext()){
            int tmp = scanner.nextInt();
            if (tmp % 4 == 0 && tmp > result){
                result = tmp;
            }
            i =tmp;
        }
        System.out.println(result);
    }
}
