public class emptyCell extends mazeCell{
    // instance variables
    obstacle creature;

    public emptyCell(){
        isWall = false;
        creature = null;
    }

    public emptyCell(obstacle ob){
        isWall = false;
        creature = ob;
    }

    public obstacle getObstacle(){
        return creature;
    }

    public boolean containsObstacle(){
        if(creature == null){
            return false;
        }
        return true;
    }
}
