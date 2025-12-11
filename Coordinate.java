/**
 * Represents a coordinate
 */

public class Coordinate {
    // instance variables
    private int row;
    private int column;

    // maze test1 = new maze();
    // maze.coordinate test = test1.new coordinate(1, 2);

    /**
     * Initalizes a coordinate with a corresponding row and column 
     * @param r row
     * @param c column
     */
    public Coordinate(int r, int c){
        row = r;
        column = c;
    }

    /**
     * Verifies whether two coordinates are equal
     * @param other coordinate to compare
     * @return true if they are equal, false if not
     */
    public boolean equals(Coordinate other){
        if(other.row == this.row && other.column == this.column){
            return true;
        }
        return false;
    }

    /**
     * Returns coordinate row
     * @return row
     */
    public int getRow(){
        return row;
    }

    /**
     * Returns coordinate column
     * @return column
     */
    public int getColumn(){
        return column;
    }

    /**
     * Changes the coordinate row
     * @param x change in row number
     */
    public void changeRow(int x){
        row += x;
    }
    
    /**
     * Changes the coordinate column
     * @param x change in column number
     */
    public void changeColumn(int x){
        column += x;
    }

    /**
     * Prints the row and column of the coordinate
     */
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
