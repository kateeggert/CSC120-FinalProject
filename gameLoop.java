import java.util.Scanner;

public class gameLoop {

    public static void main(String[] args) {

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        // Game Opening
        System.out.println("******************");
        System.out.println("WELCOME TO THE TRIWIZARD TOURNAMENT");
        System.out.println("******************");

        // Instructions
        System.out.println("Navigate the maze to find the triwizard cup! Watch out for obstacles and beware of the walls.");

        // Generate instances of the classes
        player user = new player();
        maze triwizardMaze = new maze();

        // Runs the game until the user dies or is at the end
        do {

            System.out.println("You are still playing. Follow the instructions if you want to win/lose...");
            userResponse = userInput.nextLine().toUpperCase();

            // If the user inputs a direction, move in that direction. If the direction is invalid, the user will lose health.
            triwizardMaze.move(userResponse);

            // If there is a sphinx in the user's location, run the riddle and user deduct health accordingly.
            if (triwizardMaze.isSphinx()) {
                int deductHealth;
                sphinx mySpinx = new sphinx(0, 0, userResponse, userResponse, userResponse);
                deductHealth = mySpinx.askRiddle();
                for (int i = 0; i < deductHealth; i++) {
                    user.deductHealth();
                }
            }

            // If the user runs out of health, game stops - EDIT: add other ways that the game can be finished
            if (!user.hasHealth()) {
                stillPlaying = false;
            }

            if (triwizardMaze.playerAtEnd()) {
                stillPlaying = false;
            }

        } while (stillPlaying);

        // Tidy up
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        if (triwizardMaze.playerAtEnd()) {
            System.out.println("Yay, you won the Triwizard Cup! Don't run into You Know Who anytime soon...");
        } else {
            System.out.println("Better luck next time. At least you didn't find You Know Who");
        }

    }

}