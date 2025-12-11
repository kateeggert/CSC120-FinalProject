import java.util.ArrayList;
import java.util.Arrays;
public class player {
    // Attributes
    private int health;
    private static ArrayList<String> spellBook = new ArrayList<>(Arrays.asList("Avada Kedavra", "Expelliarmus", "Crucio", "Sectumsempra", "Stupefy"));
    private static ArrayList<Integer> damage = new ArrayList<>(Arrays.asList(5, 2, 4, 3, 1));

    /**
     * Constructor
     */
    public player() {
        this.health = 20;
    }

    /**
     * Prints out the list of spells
     */
    public int getHealth(){
        return health;
    }

    public static void printSpellList(){
        for(int i = 0; i < spellBook.size(); i ++){
            System.out.println(spellBook.get(i));
        }
    }

    /**
     * Checks whether a string input is a valid spell
     * @param spell
     * @return boolean of if spell is within spell book array
     */
    public static boolean isSpell(String spell){
        return spellBook.contains(spell);
    }

    public static int getSpellDamage(String spell){
        if(!isSpell(spell)){
            return 0;
        }
        return damage.get(spellBook.indexOf(spell));
    }

    public int deductHealth() {
        this.health -= 1;
        System.out.println("You have " + this.health + " bars of health left...");
        return this.health;
    }

    /**
     * Deducts the user's health bar by a given integer and tells the user the health they have left
     * @param n number to deduct health bar by
     * @return user's health
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
     * @return boolean of if health is greater than zero
     */
    public boolean hasHealth() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

}
