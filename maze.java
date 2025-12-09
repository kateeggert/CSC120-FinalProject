public class maze{
    // instance variables
    private static final int MAZE_SIZE = 11;
    private static final Coordinate START = new Coordinate(10, 5);
    private static final Coordinate END = new Coordinate(5, 5);
    private static final String TEMPLATE = 
        "xxxxxxxxxxx" + 
        "xsoooooooox" + 
        "xoxxxxxxxox" +
        "xoxoooooxox" + 
        "xoxoxxxoxox" +
        "xoxoxoxoxox" +
        "xoxoxoxoxox" +
        "xoxoooxoxox" +
        "xoxxxxxoxox" +
        "xoooooxooox" +
        "xxxxxoxxxxx";
    public Coordinate playerPos;
    private mazeCell[][] map;

    public maze(){
        playerPos = START;
        map = new mazeCell[MAZE_SIZE][MAZE_SIZE];
        createMaze();
    }

    private void createMaze(){
        for(int i = 0; i < MAZE_SIZE; i ++){
            for(int j = 0; j < MAZE_SIZE; j ++){
                if(TEMPLATE.substring(i*MAZE_SIZE + j, i*MAZE_SIZE + j + 1).equals("x")){
                    map[i][j] = new wall();
                } else if (TEMPLATE.substring(i*MAZE_SIZE + j, i*MAZE_SIZE + j + 1).equals("s")){
                    map[i][j] = new emptyCell(new sphinx());
                } else {
                    map[i][j] = new emptyCell();
                }
            }
        }
    }

    public String toString(){
        String output = "";
        for(int i = 0; i < MAZE_SIZE; i ++){
            for(int j = 0; j < MAZE_SIZE; j ++){
                if(map[i][j].isWall){
                    output += "X";
                } else if (((emptyCell)(map[i][j])).containsObstacle()){
                    output += ((emptyCell)(map[i][j])).getObstacle().getn();
                }
                else{
                    output += " ";
                }
            }
            output += "\n";
        }
        return output;
    }

    public boolean isValidMove(String direction){
        if(direction.equals("north")){
            if(map[playerPos.getRow() - 1][playerPos.getColumn()].isWall()){
                return false;
            }
        }
        if(direction.equals("south")){
            if(map[playerPos.getRow() + 1][playerPos.getColumn()].isWall()){
                return false;
            }
        }
        if(direction.equals("east")){
            if(map[playerPos.getRow()][playerPos.getColumn() + 1].isWall()){
                return false;
            }
        }
        if(direction.equals("west")){
            if(map[playerPos.getRow()][playerPos.getColumn() - 1].isWall()){
                return false;
            }
        }
        return true;
    }

    public Coordinate move(String direction){
        if(!isValidMove(direction)){
            throw new RuntimeException("Did not check if move is valid before moving. ");
        }
        if(direction.equals("north")){
            playerPos.changeRow(-1);
        }
        if(direction.equals("south")){
            playerPos.changeRow(1);
        }
        if(direction.equals("east")){
            playerPos.changeColumn(1);
        }
        if(direction.equals("north")){
            playerPos.changeColumn(-1);
        }
        return playerPos;
    }

    public boolean playerAtEnd(){
        if(playerPos.equals(END)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        maze test = new maze();
        System.out.println(test);
    }
}