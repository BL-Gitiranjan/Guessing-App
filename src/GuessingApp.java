import java.util.Random;
import java.util.Scanner;

public class GuessingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int target = random.nextInt(100) + 1;
        int maxAttempts = 7;
        int attempts = 0;
        boolean win = false;

        System.out.print("Enter player name: ");
        String player = scanner.nextLine();

        System.out.println("\n Welcome to the Guessing App");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have 7 attempts.\n");

        while (attempts < maxAttempts) {

            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();

            int guess;

            try {
                guess = validateInput(input);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                continue;
            }

            attempts++;

            if (guess == target) {
                System.out.println("CORRECT");
                win = true;
                break;
            } else if (guess > target) {
                System.out.println("HIGH\n");
            } else {
                System.out.println("LOW\n");
            }
        }

        // Save result
        StorageService.saveResult(player, attempts, win);

        System.out.println("\nGame result saved.");
        scanner.close();
    }

    // SIMPLE validation method
    private static int validateInput(String input)
            throws InvalidInputException {

        try {
            int value = Integer.parseInt(input);

            if (value < 1 || value > 100) {
                throw new InvalidInputException(
                        "Number must be between 1 and 100"
                );
            }
            return value;

        } catch (NumberFormatException e) {
            throw new InvalidInputException(
                    "Please enter numbers only"
            );
        }
    }
}
