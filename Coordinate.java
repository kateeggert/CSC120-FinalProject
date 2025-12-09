public class Coordinate {
    // instance variables
    private int row;
    private int column;

    // maze test1 = new maze();
    // maze.coordinate test = test1.new coordinate(1, 2);

    public Coordinate(int r, int c){
        row = r;
        column = c;
    }

    public boolean equals(Coordinate other){
        if(other.row == this.row && other.column == this.column){
            return true;
        }
        return false;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public void changeRow(int x){
        row += x;
    }
    
    public void changeColumn(int x){
        column += x;
    }

    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
