public abstract class obstacle {
    
    // Attributes
    protected String name;
    protected String n;

    public obstacle(String name) {
        this.name = name;
        n = "";
    }

    public obstacle(String name, String n) {
        this.name = name;
        this.n = n;
    }

    public String getn(){
        return n;
    }

    public abstract int run();
}
