import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;
        System.out.println("======================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("======================================");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess the number!");
        System.out.println("You will receive hints after each guess.");
        while (!guessedCorrectly) {
            try {
                System.out.print("\nEnter your guess (1-100): ");
                int guess = input.nextInt();
                if (guess < 1 || guess > 100) {
                    System.out.println(
                        "Please enter a number between 1 and 100."
                    );
                    continue;
                }
                attempts++;
                if (guess < secretNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try a lower number.");
                } else {
                    guessedCorrectly = true;
                    System.out.println();
                    System.out.println("======================================");
                    System.out.println("              CORRECT!");
                    System.out.println("======================================");
                    System.out.println(
                        "You guessed the number in " + attempts + " attempts."
                    );
                    System.out.println("Thanks for playing!");
                }
            } catch (InputMismatchException e) {
                System.out.println(
                    "Invalid input. Please enter a whole number."
                );
                input.nextLine();
            }
        }
        input.close();
    }
}