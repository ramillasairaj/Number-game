import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Select difficulty level: 1. Easy (1-50)  2. Medium (1-100)  3. Hard (1-200)");
            int difficulty = scanner.nextInt();
            int range;
            int maxAttempts;

            switch (difficulty) {
                case 1:
                    range = 50;
                    maxAttempts = 7;
                    break;
                case 2:
                    range = 100;
                    maxAttempts = 5;
                    break;
                case 3:
                    range = 200;
                    maxAttempts = 3;
                    break;
                default:
                    System.out.println("Invalid choice, setting to Medium difficulty.");
                    range = 100;
                    maxAttempts = 5;
            }

            int targetNumber = random.nextInt(range) + 1;
            int attempts = 0;
            boolean hintGiven = false;
            int[] guesses = new int[maxAttempts];

            System.out.println("I have selected a number between 1 and " + range + ". Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                guesses[attempts] = userGuess;
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == 3 && !hintGiven) {
                    if (targetNumber % 2 == 0) {
                        System.out.println("Hint: The number is even.");
                    } else {
                        System.out.println("Hint: The number is odd.");
                    }
                    hintGiven = true;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // consume the newline
            String playAgainInput = scanner.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Game over! Your score: " + score);
        scanner.close();
    }
}
