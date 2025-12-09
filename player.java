import java.util.ArrayList;
import java.util.Arrays;
public class player {
    
    // Attributes
    int health;
    private static ArrayList<String> spellBook = new ArrayList<>(Arrays.asList("Avada Kedavra", "Expelliarmus", "Crucio", "Sectumsempra", "Stupefy"));


    // Constructor
    public player() {
        this.health = 20;
    }

    public void printSpellList(){
        for(int i = 0; i < spellBook.size(); i ++){
            System.out.println(spellBook.get(i));
        }
    }

    public boolean isSpell(String spell){
        return spellBook.contains(spell);
    }

    public int deductHealth() {
        this.health -= 1;
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
