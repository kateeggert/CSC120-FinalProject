import java.util.Scanner;

/**
 * Runs the game loop
 */
public class GameLoop {
    // Creates a scanner to get user input and creates class instances
    public static Scanner userInput = new Scanner(System.in);
    public static Player user = new Player();
    public static Maze triwizardMaze = new Maze();

    public static void main(String[] args) {

        // Initalizes necessary variables
        boolean stillPlaying = true;
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
            // Tells the user wehre they can move
            triwizardMaze.moveOptions();
            userResponse = userInput.nextLine();

            // Executes functions if the user inputs a command
            if (userResponse.equals("north") || userResponse.equals("south") || userResponse.equals("east") || userResponse.equals("west")){
                triwizardMaze.move(userResponse);
            } else if (Player.isSpell(userResponse)){
                System.out.println("You casted a spell");
            } else if (userResponse.equals("hint")) {
                triwizardMaze.hint();
            } else if (userResponse.equals("spell book")) {
                Player.printSpellList();
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

        // Deals with the stopping conditions
        if(userResponse.equals("end")){

        } else if (user.getHealth() < 0 && triwizardMaze.playerAtEnd()) {
            System.out.println("You fought noblely until the end, but you were not strong enough to beat Voldemort. ");
        } else if (user.getHealth() < 0 && !triwizardMaze.playerAtEnd()){
            System.out.println("Better luck next time. At least you didn't find You Know Who");
        } else {
            System.out.println("You have defeated Voldemort and saved the Wizarding world! ");
        }

    }

}