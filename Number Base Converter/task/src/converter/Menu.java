package converter;

import java.util.Scanner;

public class Menu {
    static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void fstLvlMenu() {
        System.out.print("Enter two numbers in format:" +
                " {source base} {target base} (To quit type /exit) ");

        String input = scanner.nextLine().trim();

        if (!input.equals("/exit")) {
            String[] bases = input.split(" ");
            if (bases.length == 2) {
                int sourceBase;
                int targetBase;
                while (true) {
                    try {
                        sourceBase = Integer.parseInt(bases[0]);
                        targetBase = Integer.parseInt(bases[1]);
                        sndLvlMenu(sourceBase, targetBase);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Base, try again");
                        fstLvlMenu();
                    }
                }
            } else {
                System.out.println("Invalid Base, try again");
                fstLvlMenu();
            }
        }
    }

    public static void sndLvlMenu(int sourceBase, int targetBase) {
        System.out.print("Enter number in base " + sourceBase + " to convert" +
                " to base " + targetBase + " (To go back type /back) ");

        String input = scanner.nextLine().trim().toUpperCase();

        if (input.equals("/BACK")) {
            fstLvlMenu();
        } else {
            while (true) {
                if (input.matches(".*\\d.*|.*\\w.*+\\.+.*\\d.*|.*\\w.*")) {
                    String out = BaseConverter.convert(input, sourceBase, targetBase);

                    System.out.println("Conversion result: " + out);
                    System.out.println();
                    sndLvlMenu(sourceBase, targetBase);
                    break;
                } else {
                    System.out.println("Invalid Number, try again");
                    sndLvlMenu(sourceBase, targetBase);
                }
            }
        }
    }
}