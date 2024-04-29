import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minNum = 1;
        int maxNum = 100;
        int maxAttempts = 5;
        int totalAttempts = 0;
        int rounds = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            rounds++;
            System.out.println("Round " + rounds + ":");
            int targetNumber = random.nextInt(maxNum - minNum + 1) + minNum;
            int attempts = 0;
            
            while (attempts < maxAttempts) {
                System.out.print("Guess the number between " + minNum + " and " + maxNum + ": ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts!");
                    totalAttempts += attempts;
                    break;
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used up all " + maxAttempts + " attempts. The correct number was " + targetNumber + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }
        
        if (rounds > 0) {
            System.out.println("Game Over! You played " + rounds + " round(s) and your average attempts per round were " + (double)totalAttempts / rounds);
        } else {
            System.out.println("No rounds played. Exiting the game.");
        }
        
        scanner.close();
    }
}
