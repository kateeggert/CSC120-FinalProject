import java.util.Scanner;

public class gameLoop {
    // We'll use this to get input from the user.
    public static Scanner userInput = new Scanner(System.in);
    public static player user = new player();
    public static maze triwizardMaze = new maze();

    public static void main(String[] args) {

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // Storage for user's responses
        String userResponse = "";

        // Game Opening
        System.out.println("******************");
        System.out.println("WELCOME TO THE TRIWIZARD TOURNAMENT");
        System.out.println("******************");

        // Instructions
        System.out.println("Navigate the maze to find the triwizard cup! Watch out for obstacles and beware of the walls.");
        System.out.println("Type in \"north\", \"south\", \"east\", or \"west\" to move. ");
        System.out.println("Type in \"hint\" to see a print out of the maze.");
        System.out.println("Type in \"spell book\" to see the list of spells you can use.");

        // Runs the game until the user dies or is at the end
        do {
            triwizardMaze.moveOptions();
            //System.out.println("You are still playing. Follow the instructions if you want to win/lose...");
            userResponse = userInput.nextLine();

            // If the user inputs a direction, move in that direction. If the direction is invalid, the user will lose health.
            if (userResponse.equals("north") || userResponse.equals("south") || userResponse.equals("east") || userResponse.equals("west")){
                triwizardMaze.move(userResponse);
            } else if (player.isSpell(userResponse)){
                System.out.println("You casted a spell");
            } else if (userResponse.equals("hint")) {
                System.out.println(triwizardMaze);
            } else if (userResponse.equals("spell book")) {
                player.printSpellList();
            } else if (userResponse.equals("end")){
                stillPlaying = false;
            }

            // Runs the game
            user.deductHealth(triwizardMaze.play());

            // If the user runs out of health, game stops
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
        if (user.getHealth() < 0 && triwizardMaze.playerAtEnd()) {
            System.out.println("You fought noblely until the end, but you were not strong enough to beat Voldemort. ");
        } else if (user.getHealth() < 0 && !triwizardMaze.playerAtEnd()){
            System.out.println("Better luck next time. At least you didn't find You Know Who");
        } else {
            System.out.println("You have defeated Voldemort and saved the Wizarding world! ");
        }

    }

}