import java.util.ArrayList;
import java.util.Arrays;
public class player {
    
<<<<<<< HEAD
    int health;
=======
    // Attributes
    private int health;
>>>>>>> 2145706171a3e49189a8b16231573b37ad56c655
    private static ArrayList<String> spellBook = new ArrayList<>(Arrays.asList("Avada Kedavra", "Expelliarmus", "Crucio", "Sectumsempra", "Stupefy"));
    private static ArrayList<Integer> damage = new ArrayList<>(Arrays.asList(5, 2, 4, 3, 1));

    /**
     * Constructor
     */
    public player() {
        this.health = 20;
    }

<<<<<<< HEAD
    /**
     * Prints out the list of spells
     */
    public void printSpellList(){
=======
    public int getHealth(){
        return health;
    }

    public static void printSpellList(){
>>>>>>> 2145706171a3e49189a8b16231573b37ad56c655
        for(int i = 0; i < spellBook.size(); i ++){
            System.out.println(spellBook.get(i));
        }
    }

<<<<<<< HEAD
    /**
     * Checks whether a string input is a valid spell
     * @param spell
     * @return boolean of if spell is within spell book array
     */
    public boolean isSpell(String spell){
        return spellBook.contains(spell);
    }

    /**
     * Deducts the user's health bar by one and tells the user the health they have left
     * @return user's health
     */
=======
    public static boolean isSpell(String spell){
        return spellBook.contains(spell);
    }

    public static int getSpellDamage(String spell){
        if(!isSpell(spell)){
            return 0;
        }
        return damage.get(spellBook.indexOf(spell));
    }

>>>>>>> 2145706171a3e49189a8b16231573b37ad56c655
    public int deductHealth() {
        this.health -= 1;
        System.out.println("Watch out! You only have " + this.health + " left...");
        return this.health;
    }

    /**
     * Deducts the user's health bar by a given integer and tells the user the health they have left
     * @param n number to deduct health bar by
     * @return user's health
     */
    public int deductHealth(int n) {
        this.health -= n;
        System.out.println("Watch out! You only have " + this.health + " left...");
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
