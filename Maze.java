import java.util.ArrayList;

/**
 * Represents the TriWizard Maze
 */
public class Maze {
    // instance variables
    private static final int MAZE_SIZE = 16;
    private static final Coordinate START = new Coordinate(14, 9);
    private static final Coordinate END = new Coordinate(1, 14);
    // private static final String DRAFT_TEMPLATE = 
    //     "xxxxxxxxxxx" +
    //     "xsoooooooox" +
    //     "xoxxxxxxxox" +
    //     "xoxoooooxox" +
    //     "xoxoxxxoxox" +
    //     "xoxoxoxoxox" +
    //     "xoxoxoxoxox" +
    //     "xoxoooxoxox" +
    //     "xoxxxxxoxox" +
    //     "xoooooxooox" +
    //     "xxxxxxxxxxx";
    private static final String TEMPLATE = 
        "xxxxxxxxxxxxxxxx" + 
        "xoooxoooooooxxvx" + 
        "xoxoooxxxoxoooox" + 
        "xoxxxxxoooxxxxox" +
        "xoooooxoxooooxxx" + 
        "xxxxxsxxxxxxoxox" +
        "xoooxoxoooxooxox" +
        "xoxoxoooxoooxxox" +
        "xoxoxxxoxxxxxoox" +
        "xoxoooxoooooooxx" +
        "xoxxxoooxxxxxoxx" +
        "xoooxxxxxoooxoox" +
        "xxxoxoooooxoxxox" +
        "xoxoxoxxxxxoooox" +
        "xoooxoooooxooxox" +
        "xxxxxxxxxxxxxxxx";
    public Coordinate playerPos;
    private MazeCell[][] map;

    /**
     * initalizes player position at the start and creates the maze
     */
    public Maze() {
        playerPos = START;
        map = new MazeCell[MAZE_SIZE][MAZE_SIZE];
        createMaze();
    }

    /**
     * Creates a maze with "X" for a wall, "S" for a sphinx, and "V" for Voldemort
     */
    private void createMaze() {
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (TEMPLATE.substring(i * MAZE_SIZE + j, i * MAZE_SIZE + j + 1).equals("x")) {
                    map[i][j] = new Wall();
                } else if (TEMPLATE.substring(i * MAZE_SIZE + j, i * MAZE_SIZE + j + 1).equals("s")) {
                    map[i][j] = new EmptyCell(new Sphinx());
                } else if (TEMPLATE.substring(i * MAZE_SIZE + j, i * MAZE_SIZE + j + 1).equals("v")) {
                    map[i][j] = new EmptyCell(new Voldemort());
                } else {
                    map[i][j] = new EmptyCell();
                }
            }
        }
    }

    /**
     * Prints out the maze
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (map[i][j].isWall) {
                    output += "X";
                } else if((new Coordinate(i, j)).equals(playerPos)){
                    output += "P";
                } else if (((EmptyCell) (map[i][j])).containsObstacle()) {
                    output += ((EmptyCell) (map[i][j])).getObstacle().getn();
                } else {
                    output += " ";
                }
            }
            output += "\n";
        }
        return output;
    }

    /**
     * Prints out the maze with the player's current position
     */
    public void hint(){
        String output = "";
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (map[i][j].isWall) {
                    output += "X";
                } else if((new Coordinate(i, j)).equals(playerPos)){
                    output += "P";
                } else if ((new Coordinate(i, j)).equals(END)) {
                    output += "E";
                } else {
                    output += " ";
                }
            }
            output += "\n";
        }
        System.out.println(output);
    }

    /**
     * Determines if the user's move is to an empty cell
     * @param direction the direcition the user wants to move
     * @return true if the space is empty, false if it is a wall
     */
    public boolean isValidMove(String direction) {
        if (direction.contains("north")) {
            if (map[playerPos.getRow() - 1][playerPos.getColumn()].isWall()) {
                return false;
            }
        }
        if (direction.contains("south")) {
            if (map[playerPos.getRow() + 1][playerPos.getColumn()].isWall()) {
                return false;
            }
        }
        if (direction.contains("east")) {
            if (map[playerPos.getRow()][playerPos.getColumn() + 1].isWall()) {
                return false;
            }
        }
        if (direction.contains("west")) {
            if (map[playerPos.getRow()][playerPos.getColumn() - 1].isWall()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Changes the player's position 
     * @param direction the direction the user wants to move to
     * @return the player's position
     */
    public Coordinate move(String direction) {
        if (!isValidMove(direction)) {
            System.out.println("That's a wall! Try again. ");
            return playerPos;
        }
        if (direction.contains("north")) {
            playerPos.changeRow(-1);
        }
        else if (direction.contains("south")) {
            playerPos.changeRow(1);
        }
        else if (direction.contains("east")) {
            playerPos.changeColumn(1);
        }
        else if (direction.contains("west")) {
            playerPos.changeColumn(-1);
        }
        return playerPos;
    }

    /**
     * Tracks the user's health deduction as the game runs
     */
    public int play() {
        int healthDeduction = 0;
        if (((EmptyCell) map[playerPos.getRow()][playerPos.getColumn()]).containsObstacle()) {
            healthDeduction += ((EmptyCell) map[playerPos.getRow()][playerPos.getColumn()]).getObstacle().run();
        }
        return healthDeduction;
    }

    /**
     * Prints out the directions that the user can move to without hitting a wall
     */
    public void moveOptions(){
        ArrayList<String> output = new ArrayList<>();

        if (!map[playerPos.getRow() - 1][playerPos.getColumn()].isWall()) {
            output.add("north");
        }
        if (!map[playerPos.getRow() + 1][playerPos.getColumn()].isWall()) {
            output.add("south");
        }
        if (!map[playerPos.getRow()][playerPos.getColumn() + 1].isWall()) {
            output.add("east");
        }
        if (!map[playerPos.getRow()][playerPos.getColumn() - 1 ].isWall()) {
            output.add("west");
        }

        System.out.print("You can move ");
        for(int i = 0; i < output.size(); i ++){
            System.out.print(output.get(i) + " ");
        }
        System.out.println();
    }

    /**
     * Returns whether the player's position is at the end
     * @return true if the player is at the end, false if otherwise
     */
    public boolean playerAtEnd() {
        if (playerPos.equals(END)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Maze test = new Maze();
        System.out.println(test);
    }
}