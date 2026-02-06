import java.util.Scanner;

public class GuessingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameConfig config = new GameConfig();

        int attempts = 0;
        int hintsUsed = 0;

        config.printWelcome();

        while (attempts < config.getMaxAttempts()) {

            System.out.print("Enter your guess: ");

            String input = scanner.nextLine();
            int guess;

            try {
                guess = ValidationService.validateInput(input);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                System.out.println();
                continue; // retry without counting attempt
            }

            attempts++;

            String result = GuessValidator.validateGuess(
                    guess, config.getTarget()
            );

            if (!"CORRECT".equals(result)
                    && hintsUsed < config.getMaxHints()) {

                hintsUsed++;
                System.out.println(HintService.getHint(config.getTarget(),hintsUsed));

            } else if (!"CORRECT".equals(result)) {
                System.out.println("No more hints available");
            }

            System.out.println(result + "\n");

            if ("CORRECT".equals(result)) {
                break;
            }
        }

        scanner.close();
    }
}


