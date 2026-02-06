import java.util.Random;
import java.util.Scanner;

public class GuessingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean restart;

        System.out.println("==============================");
        System.out.println("Welcome to the Guessing App");
        System.out.println("==============================\n");

        do {
            // RESET GAME VARIABLES
            int target = new Random().nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean win = false;

            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have 7 attempts.\n");

            // GAME LOOP
            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == target) {
                    System.out.println("CORRECT 🎉");
                    win = true;
                    break;
                } else if (guess > target) {
                    System.out.println("HIGH\n");
                } else {
                    System.out.println("LOW\n");
                }
            }

            // FINAL SUMMARY
            System.out.println("\n----- Game Summary -----");
            System.out.println("Attempts used : " + attempts);
            System.out.println("Result        : " + (win ? "WIN" : "LOSS"));
            System.out.println("------------------------\n");

            // CLEAR INPUT BUFFER
            scanner.nextLine();

            // RESTART / EXIT DECISION
            restart = GameController.restartGame(scanner);
            System.out.println();

        } while (restart);

        // CLEAN SHUTDOWN
        scanner.close();
        System.out.println("Thank you for playing. Goodbye!");
    }
}
