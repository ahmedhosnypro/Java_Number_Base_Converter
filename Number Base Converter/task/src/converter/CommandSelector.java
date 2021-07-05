package converter;

import java.util.Scanner;

public class CommandSelector {
    static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static Command selectCommand() {
        System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
        String inputCommand = scanner.nextLine().trim().
                replaceAll("/", "").toUpperCase();
        Command command = Command.invalidCommand;
        try {
            command = Command.valueOf(inputCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (command == Command.invalidCommand) {
            selectCommand();
        }
        return command;
    }
}
