package converter;

import java.util.Scanner;

public abstract class NumberInputParser {
    static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }

    String[] parseNumber(){
        return new String[0];
    }

    String[] parseStringNumber(){
        return new String[0];
    }

}

class ParserFactory {
    public NumberInputParser createParser(Command command) {
        switch (command) {
            case FROM:
                return new NonHexNumberParser();
            case TO:
                return new HexNumberParser();
            default:
                return null;
        }
    }
}

class NonHexNumberParser extends NumberInputParser {
    String[] parseNumber() {
        String[] out = new String[2];
        System.out.print("Enter number in decimal system: ");
        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine().trim());
                out[0] = String.valueOf(n);
                break;
            } catch (NumberFormatException ignored) {
            }
        }
        System.out.print("Enter target base: ");
        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine().trim());
                out[1] = String.valueOf(n);
                break;
            } catch (NumberFormatException ignored) {
            }
        }
        return out;
    }
}

class HexNumberParser extends NumberInputParser {
    String[] parseStringNumber() {
        String[] out = new String[2];
        System.out.print("Enter source number: ");
        while (true) {
            String hex = scanner.nextLine().trim().toUpperCase();
            if (hex.matches("^[A-F]")) {
                continue;
            } else out[0] = hex;
            break;
        }
        System.out.print("Enter source base: ");
        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine().trim());
                out[1] = String.valueOf(n);
                break;
            } catch (NumberFormatException ignored) {
            }
        }
        return out;
    }
}


