import java.util.ArrayList;
import java.util.Arrays;
public class Player {
    // Attributes
    private int health;
    private static ArrayList<String> spellBook = new ArrayList<>(Arrays.asList("avada kedavra", "expelliarmus", "crucio", "sectumsempra", "stupefy"));
    private static ArrayList<Integer> damage = new ArrayList<>(Arrays.asList(5, 2, 4, 3, 1));

    /**
     * Creates a player with initial health of 20
     */
    public Player() {
        this.health = 20;
    }

    /**
     * Returns the user's health level
     * @return user's health level
     */
    public int getHealth(){
        return health;
    }

    /**
     * Prints out the list of valid spells
     */
    public static void printSpellList(){
        for(int i = 0; i < spellBook.size(); i ++){
            System.out.println(spellBook.get(i));
        }
    }

    /**
     * Checks whether a string input is a valid spell
     * @param spell user's input
     * @return true if spell is in the spell book array, false if otherwise
     */
    public static boolean isSpell(String spell){
        return spellBook.contains(spell);
    }

    /**
     * Returns the damage each spell causes
     * @param spell user's input
     * @return int of amount of damage
     */
    public static int getSpellDamage(String spell){
        if(!isSpell(spell)){
            return 0;
        }
        return damage.get(spellBook.indexOf(spell));
    }

    /**
     * Deducts the user's health by one and prints the amount of health left
     * @return the updated health
     */
    public int deductHealth() {
        this.health -= 1;
        System.out.println("You have " + this.health + " bars of health left...");
        return this.health;
    }

    /**
     * Deducts the user's health bar by a given integer and prints the amount of health left
     * @param n number to deduct health bar by
     * @return the updated health
     */
    public int deductHealth(int n) {
        this.health -= n;
        if (n > 0) {
            System.out.println("You have " + this.health + " bars of health left...");
        }
        return this.health;
    }
    
    /**
     * Checks to see whether the user still has health
     * @return true if health is greater than zero, false if otherwise
     */
    public boolean hasHealth() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

}
