import java.util.Random;
import java.util.Scanner;

public class Main {

    static final String[] CHOICES = {"rock", "paper", "scissors"};
    static int wins = 0, losses = 0, ties = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
            System.out.println("""

██████╗  ██████╗  ██████╗██╗  ██╗
██╔══██╗██╔═══██╗██╔════╝██║ ██╔╝
██████╔╝██║   ██║██║     █████╔╝\s
██╔══██╗██║   ██║██║     ██╔═██╗\s
██║  ██║╚██████╔╝╚██████╗██║  ██╗
╚═╝  ╚═╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝

        ██████╗  █████╗ ██████╗ ███████╗██████╗
        ██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗
        ██████╔╝███████║██████╔╝█████╗  ██████╔╝
        ██╔═══╝ ██╔══██║██╔═══╝ ██╔══╝  ██╔══██╗
        ██║     ██║  ██║██║     ███████╗██║  ██║
        ╚═╝     ╚═╝  ╚═╝╚═╝     ╚══════╝╚═╝  ╚═╝

███████╗ ██████╗██╗███████╗███████╗ ██████╗ ██████╗ ███████╗
██╔════╝██╔════╝██║██╔════╝██╔════╝██╔═══██╗██╔══██╗██╔════╝
███████╗██║     ██║███████╗███████╗██║   ██║██████╔╝███████╗
╚════██║██║     ██║╚════██║╚════██║██║   ██║██╔══██╗╚════██║
███████║╚██████╗██║███████║███████║╚██████╔╝██║  ██║███████║
╚══════╝ ╚═════╝╚═╝╚══════╝╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝

""");

        System.out.println("Rock, Paper, Scissors! Type 'quit' to stop.");

        while (true) {
            System.out.print("\nYour choice (rock/paper/scissors): ");
            String player = scanner.nextLine().trim().toLowerCase();

            if (player.equals("quit")) break;

            if (!player.equals("rock") && !player.equals("paper") && !player.equals("scissors")) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            String computer = CHOICES[random.nextInt(3)];
            System.out.println("Computer chose: " + computer);

            if (player.equals(computer)) {
                System.out.println("It's a tie!");
                ties++;
            } else if (beats(player, computer)) {
                System.out.println("You win!");
                wins++;
            } else {
                System.out.println("You lose!");
                losses++;
            }

            System.out.printf("Score - Wins: %d, Losses: %d, Ties: %d%n", wins, losses, ties);
        }

        System.out.println("\nFinal Score - Wins: " + wins + ", Losses: " + losses + ", Ties: " + ties);
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    static boolean beats(String a, String b) {
        return (a.equals("rock") && b.equals("scissors"))
            || (a.equals("scissors") && b.equals("paper"))
            || (a.equals("paper") && b.equals("rock"));
    }
}
