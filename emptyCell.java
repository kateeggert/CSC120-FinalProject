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
}
