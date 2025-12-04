public class player {
    
    // Attributes
    int xPosition;
    int yPosition;
    int health;

    // Constructor
    public player() {
        this.xPosition = 6; 
        this.yPosition = 0;
        this.health = 20;
    }

    public void move(String direction) {
        // EDIT LATER check if there is a wall, if so deduct health. Also make sure that xPos and yPos don't go beyond the maze
        // also potentially make a boolean in the maze class to verify if the cell is correct
        if (direction == "Right"){
            if ((this.xPosition += 1) > 16) {
                System.out.println("You have reached the end of the maze. You cannot move any farther");
            } 
            this.xPosition += 1;
        } else if (direction == "Left") {
            if ((this.xPosition -= 1) < 0) {
                System.out.println("You have reached the end of the maze. You cannot move any farther");
            }
            this.xPosition -= 1;
        } else if (direction == "Forwards") {
            if ((this.yPosition += 1) > 16) {
                System.out.println("You have reached the end of the maze. You cannot move any farther");
            }
            this.yPosition += 1;
        } else if (direction == "Backwards") {
            if ((this.yPosition -= 1) > 0) {
                System.out.println("You have reached the end of the maze. You cannot move any farther");
            }
            this.yPosition -=1;
        } 
    }

    public void castSpell(String spell){
        // Create a spellbook in the spell class
        if (!spell.spellBook.contains(spell)) {
            System.out.println("Need to use a valid spell");
        // sout description of what the spell does ?
        } System.out.println(spell.description);
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
