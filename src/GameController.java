import java.util.Scanner;

/**
 * Handles game lifecycle decisions
 * (Restart or Exit)
 */
public class GameController {

    public static boolean restartGame(Scanner scanner) {

        System.out.print("Do you want to play again? (yes/no): ");
        String choice = scanner.nextLine();

        return choice.equalsIgnoreCase("yes");
    }
}

