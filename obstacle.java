public class obstacle {
    
    // Attributes
    int xPosition;
    int yPosition;
    String name;

    public obstacle(int xPosition, int yPosition, String name) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.name = name;
    }

    public obstacle() {
        this(0, 0, null);
    }

}
