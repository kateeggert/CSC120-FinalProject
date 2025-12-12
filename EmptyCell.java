/**
 * Represents an maze cell empty cell
 */
public class EmptyCell extends MazeCell{
    // instance variables
    Obstacle creature;

    /**
     * Creates a empty cell that does not have an obstacle
     */
    public EmptyCell(){
        isWall = false;
        creature = null;
    }

    /**
     * Creates an empty cell that does have an obstacle
     * @param ob obstacle
     */
    public EmptyCell(Obstacle ob){
        isWall = false;
        creature = ob;
    }

    /**
     * Returns obstacle
     * @return osbtacle
     */
    public Obstacle getObstacle(){
        return creature;
    }

    /**
     * Returns whether an obstacle is present in the cell
     * @return true if there is an obstacle, false if there is not
     */
    public boolean containsObstacle(){
        if(creature == null){
            return false;
        }
        return true;
    }
}
