import java.util.ArrayList;

/**
 * Represents a sphinx obstacle
 */
public class Sphinx extends Obstacle{

    private String riddle;
    private ArrayList<String> riddleAnswers;
    
    /** 
     * Creates a Sphinx with a riddle and possible riddle solutions
     */
    public Sphinx() {
        super("Sphinx", "S");
        this.riddle = "I have no nose, but I can still smell, A dark lord who rose, then terribly fell. My name brings fear, they dare not say.";
        this.riddleAnswers = new ArrayList<String>(java.util.Arrays.asList("Lord Voldemort", "Voldemort", "voldemort"));
    }

    /**
     * Requires the user to guess the riddle before they may pass, deducting health each time
     * @return integer of the number of total health the user loses in the interaction
     */
    public int run() {
        boolean isCorrect = false;
        String userResponse = "";
        int deductHealth = 0;

        System.out.println("Figure out the riddle before you may pass");
        System.out.println(this.riddle);

        do {
            userResponse = GameLoop.userInput.nextLine();

            if (riddleAnswers.contains(userResponse)) {
                isCorrect = true;
            } else {
                deductHealth += 1;    
                System.out.println("You lost one health bar. Guess again!");
            }

        } while(!isCorrect);
        return deductHealth;
    }
}
