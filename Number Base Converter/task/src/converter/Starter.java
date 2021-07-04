package converter;

import java.util.Scanner;

public class Starter {
    public static  void start() {
        InputParser parser = new standardInputParser();
        int[] input = parser.parse();
        ConvertFactory convertFactory = new ConvertFactory();
        BaseConverter converter = convertFactory.createConverter(10);
        String out = converter.convert(input[0], input[1]);
        System.out.println(out);
    }
}




abstract class InputParser {
    static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }

    abstract int[] parse();

}

class standardInputParser extends InputParser{

    @Override
    int[] parse() {
        int[] out = new int[2];

        while (true) {
            try{
                out[0] = Integer.parseInt(scanner.next().trim());
                break;
            }catch(NumberFormatException ignored){}
        }
        while (true) {
            try{
                out[1] = Integer.parseInt(scanner.next().trim());
                break;
            }catch(NumberFormatException ignored){}
        }

        return out;
    }
}