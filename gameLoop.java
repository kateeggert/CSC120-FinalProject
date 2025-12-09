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
        System.out.println("Navigate the maze to find the triwizard cup! Watch out for obstacles and the shifting walls.");

        // Generate instances of the classes
        player user = new player();
        maze triwizardMaze = new maze();

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            System.out.println("You are still playing. Follow the instructions if you want to win/lose...");
            userResponse = userInput.nextLine().toUpperCase();
            // If the user inputs a direction, move in that direction. If not, nothing will happen.
            triwizardMaze.move(userResponse);
            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓

            // If the user runs out of health, game stops - EDIT: add other ways that the game can be finished
            if (!user.hasHealth()) {
                stillPlaying = false;
            }
        } while (stillPlaying);

        // Tidy up
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        if (userResponse.equals("WIN")) {
            System.out.println("Yay, you won!");
        } else { // userResponse.equals("LOSE")
            System.out.println("Better luck next time.");
        }

    }

}