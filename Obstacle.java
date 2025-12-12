public abstract class Obstacle {
    
    // Attributes
    protected String name;
    protected String n;

    /**
     * Creates an obstacle with a name, no nickname
     * @param name
     */
    public Obstacle(String name) {
        this.name = name;
        n = "";
    }

    /**
     * Creates an obstacle with a name and a nickname
     * @param name obstacle name
     * @param n obstacle nickname
     */
    public Obstacle(String name, String n) {
        this.name = name;
        this.n = n;
    }

    /**
     * Returns the nickname of the obstacle
     * @return obstacle nickname
     */
    public String getn(){
        return n;
    }

    /**
     * Runs the obstacle's actions
     * @return int of the user's health deduction
     */
    public abstract int run();
}
