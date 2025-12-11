/**
 * Represents a Voldemort obstacle
 */
public class Voldemort extends Obstacle {

    /**
     * Creates Voldemort with a the name and nickname
     */
    public Voldemort() {
        super("Voldemort", "V");
    }

    /**
     * Requires the user to fight Voldemort before they win the game by using correct skills, or else health is deducted
     * @return integer of the total health the user loses in the interaction
     */
    public int run() {
        int deductHealth = 0;
        int voldemortHealth = 10;
        String userResponce = "";

        System.out.println("You have reached the end of the maze and grab the Triwizard Tourment Trophy and are suddenly teleported");
        System.out.println("to a graveyard. It'a a trap! Peter Pettigrew aproaches and throws you into a statue and you watch him");
        System.out.println("throw the remains of he who must not be named into a cauldron. He comes over to you and draws your blood");
        System.out.println("for the potion. A figure rises out of the Cauldron, it's Voldemort! Cast spells to protect yourself!"); 
        System.out.println("(type \"spell book\" to view the spells you know). ");

        while (voldemortHealth > 0 && GameLoop.user.getHealth() - deductHealth > 0) {
            userResponce = GameLoop.userInput.nextLine();
            if (Player.isSpell(userResponce)) {
                voldemortHealth -= Player.getSpellDamage(userResponce);
                if (voldemortHealth > 0) {
                    System.out.println("Good choice. Keep casting spells. ");
                }
            } else if (userResponce.equals("spell book")) {
                Player.printSpellList();
            } else {
                System.out.println("That's not a spell, Voldemort has hit you. Minus 2 hearts. ");
                deductHealth += 2;
            }
        }
        return deductHealth;
    }
}
