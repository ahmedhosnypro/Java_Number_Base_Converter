package converter;

import java.util.Scanner;

import static converter.Command.*;
import static converter.CommandSelector.selectCommand;

public class Starter {
    static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static boolean start() {
        boolean isNotFinished = true;
        Command command = selectCommand();

        ParserFactory parserFactory = new ParserFactory();
        NumberInputParser numberInputParser;

        ConvertFactory convertFactory = new ConvertFactory();
        BaseConverter decimalConverter =convertFactory.createConverter();

        String[] numbs;
        StringBuilder out = new StringBuilder();

        switch (command) {
            case FROM:
                numberInputParser = parserFactory.createParser(FROM);
                numbs = numberInputParser.parseNumber();
                out.append("Conversion result: ");
                out.append(decimalConverter.fromBaseConvert(numbs[0], numbs[1]));
                System.out.println(out);
                break;
            case TO:
                numberInputParser = parserFactory.createParser(TO);
                numbs = numberInputParser.parseStringNumber();
                out.append("Conversion to decimal result: ");
                out.append(decimalConverter.toBaseConverter(numbs[0], numbs[1]));
                System.out.println(out);
                break;
            case EXIT:
                isNotFinished = false;
                break;
            default:
                break;
        }
        return isNotFinished;
    }
}

