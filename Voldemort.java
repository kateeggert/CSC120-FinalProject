public class Voldemort extends obstacle {
    public Voldemort() {
        super("Voldemort", "V");
    }

    public int run() {
        int deductHealth = 0;
        int voldemortHealth = 10;
        String userResponce = "";

        System.out.println("You have reached the end of the maze and grab the Triwizard Tourment Trophy," +
                "and are suddenly teleported to a graveyard. It'a a trap! Peter Pettigrew aproaches and throws you into a statue"
                +
                " and you watch him throw the remains of he who must not be named into a cauldron. He comes over to you and draws"
                +
                " your blood for the potion. A figure rises out of the Cauldron, it's Voldemort! Cast spells to protect yourself! ");
        while (voldemortHealth > 0 && gameLoop.user.getHealth() - deductHealth > 0) {
            userResponce = gameLoop.userInput.nextLine();
            if (player.isSpell(userResponce)) {
                voldemortHealth -= player.getSpellDamage(userResponce);
                if (voldemortHealth > 0) {
                    System.out.println("Good choice. Keep casting spells. ");
                }
            } else if (userResponce.equals("spell book")) {
                player.printSpellList();
            } else {
                System.out.println("That's not a spell, Voldemort has hit you. Minus 2 hearts. ");
                deductHealth += 2;
            }
        }
        return deductHealth;
    }
}
