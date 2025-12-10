import java.util.ArrayList;
import java.util.Arrays;
public class player {
    
    // Attributes
    private int health;
    private static ArrayList<String> spellBook = new ArrayList<>(Arrays.asList("Avada Kedavra", "Expelliarmus", "Crucio", "Sectumsempra", "Stupefy"));
    private static ArrayList<Integer> damage = new ArrayList<>(Arrays.asList(5, 2, 4, 3, 1));

    // Constructor
    public player() {
        this.health = 20;
    }

    public int getHealth(){
        return health;
    }

    public static void printSpellList(){
        for(int i = 0; i < spellBook.size(); i ++){
            System.out.println(spellBook.get(i));
        }
    }

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
        return this.health;
    }

    public int deductHealth(int n) {
        this.health -= n;
        return this.health;
    }
    
    public boolean hasHealth() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

}
