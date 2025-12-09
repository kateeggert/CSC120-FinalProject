import java.util.Scanner;
import java.util.ArrayList;

public class sphinx extends obstacle{

    private String riddle;
    private ArrayList<String> riddleAnswers;
    
    public sphinx() {
        super("Sphinx", "s");
        this.riddle = "I have no nose, but I can still smell, A dark lord who rose, then terribly fell. My name brings fear, they dare not say.";
        this.riddleAnswers = new ArrayList<String>(java.util.Arrays.asList("Lord Voldemort", "Voldemort", "voldemort"));
    }

    public int run() {

        boolean isCorrect = false;
        String userResponse = "";
        int deductHealth = -1;

        Scanner guess = new Scanner(System.in);
        System.out.println("Figure out the riddle before you may pass");
        System.out.println(this.riddle);

        do {
            deductHealth += 1;    
            System.out.println("Make a guess... or risk death");
            userResponse = guess.nextLine();

            if (riddleAnswers.contains(userResponse)) {
                isCorrect = true;
            }

        } while(!isCorrect);

        guess.close();
        return deductHealth;
    }
}
