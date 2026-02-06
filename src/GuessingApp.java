import java.util.Scanner;

public class GuessingApp {
    public static void main(String[] args) {
        System.out.println("Welcome to guessing app");
        GameConfig config=new GameConfig();
        config.showRules();
        Scanner scanner=new Scanner(System.in);
        int attempts=0;
        while(attempts<config.getMaxAttempts())
        {
            System.out.println("enter your guess");
       int guess=scanner.nextInt();
       attempts++;
       String result=GuessValidator.validateGuess(guess,config.getTargetNumber());
            System.out.println(result);
            if("Correct".equals(result))
            {
                break;
            }
        }
    }
}