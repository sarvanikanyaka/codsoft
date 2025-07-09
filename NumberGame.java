import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalScore = 0;
        String restart;

        do {
            int secret = ThreadLocalRandom.current().nextInt(1, 101);
            int tries = 0, maxTries = 7;
            boolean guessed = false;

            System.out.println(" New Game: Guess a number between 1 and 100");

            while (tries < maxTries) {
                System.out.print("Attempt " + (tries + 1) + ": ");
                int guess = input.nextInt();
                tries++;

                if (guess == secret) {
                    System.out.println("🎉 Well done! You found it in " + tries + " tries.");
                    totalScore++;
                    guessed = true;
                    break;
                } else if (guess < secret) {
                    System.out.println("Too low ");
                } else {
                    System.out.println("Too high ");
                }
            }

            if (!guessed) {
                System.out.println(" Out of tries! The number was: " + secret);
            }

            System.out.print("Play another round? (yes/no): ");
            restart = input.next();
        } while (restart.equalsIgnoreCase("yes"));

        System.out.println(" Game over. Total rounds won: " + totalScore);
        input.close();
    }
}
