import java.util.Scanner;

public class GuessingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameConfig config = new GameConfig();

        int attempts = config.getMaxAttempts();
        int hintCount = 0;

        config.printWelcome();

        while (attempts > 0) {

            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == config.getTarget()) {
                System.out.println("CORRECT");
                break;
            }

            attempts--;

            // Hint logic
            if (hintCount < config.getMaxHints()) {
                hintCount++;
                System.out.println(
                        HintService.getHint(config.getTarget(), hintCount)
                );
            } else {
                System.out.println("No more hints available");
            }

            // HIGH / LOW feedback
            if (guess > config.getTarget()) {
                System.out.println("HIGH\n");
            } else {
                System.out.println("LOW\n");
            }
        }

        scanner.close();
    }
}

