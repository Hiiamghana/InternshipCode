

//TASK 1
//
//        1. Generate a random number within a specified range, such as 1 to 100.
//
//        2. Prompt the user to enter their guess for the generated number.
//
//        3. Compare the user's guess with the generated number and provide feedback on whether the guess
//        is correct, too high, or too low.
//
//        4. Repeat steps 2 and 3 until the user guesses the correct number.
//
//        You can incorporate additional details as follows:
//
//        5. Limit the number of attempts the user has to guess the number.
//        6. Add the option for multiple rounds, allowing the user to play again.
//        7. Display the user's score, which can be based on the number of attempts taken or rounds won.




import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner to read user input
        Random random = new Random();             // Object for Random number generator

        int maxAttempts = 5;                      // Maximum number of attempts allowed per round
        int score = 0;                            // Score based on number of rounds won
        boolean playAgain = true;                 // Flag to control game loop

        System.out.println("Welcome to the Guess the Number Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attemptsLeft = maxAttempts;              // Reset attempts for each round
            boolean hasGuessedCorrectly = false;         // Track whether user guessed correctly

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");


            // User attempts loop
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();       // Read user input

                if (userGuess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number.");
                    hasGuessedCorrectly = true;
                    score++;                             // Increase score for correct guess
                    break;                               // Exit the loop
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attemptsLeft--; // Decrease the remaining attempts
                System.out.println("Attempts left: " + attemptsLeft);
            }

            // If user failed to guess the number
            if (!hasGuessedCorrectly) {
                System.out.println(" You've run out of attempts. The correct number was: " + numberToGuess);
            }

            // Ask if the user wants to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes"); // Continue if user types "yes"
        }

        // Display the final score
        System.out.println("\nGame over! Your total score (rounds won): " + score);
        scanner.close(); // Close the scanner to free system resources
    }
}
