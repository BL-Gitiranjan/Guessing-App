import java.util.Random;

public class GameConfig {

    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;
    private final int MAX_HINTS = 2;

    private int target;

    public GameConfig() {
        target = new Random().nextInt(MAX - MIN + 1) + MIN;
    }

    public int getTarget() {
        return target;
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    public int getMaxHints() {
        return MAX_HINTS;
    }

    public void printWelcome() {
        System.out.println("Welcome to the Guessing App");
        System.out.println("🎯 Guess a number between " + MIN + " and " + MAX);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");
        System.out.println("Hints will be provided after wrong guesses.\n");
    }
}

