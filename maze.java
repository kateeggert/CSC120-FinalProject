public class maze{
    // instance variables
    private static final int MAZE_SIZE = 11;
    //private static final coordinate START;
    //private static final coordinate END;
    private coordinate playerPos;
    private mazeCell[][] map;

    public maze(){
        //playerPos = START;
        map = new mazeCell[MAZE_SIZE][MAZE_SIZE];
        createMaze();
    }

    private void createMaze(){
        String template = 
        "xxxxxxxxxxx" + 
        "xooooooooox" + 
        "xoxxxxxxxox" +
        "xoxoooooxox" + 
        "xoxoxxxoxox" +
        "xoxoxoxoxox" +
        "xoxoxoxoxox" +
        "xoxoooxoxox" +
        "xoxxxxxoxox" +
        "xoooooxooox" +
        "xxxxxoxxxxx";

        for(int i = 0; i < 11; i ++){
            for(int j = 0; j < 11; j ++){
                if(template.substring(i*11 + j, i*11 + j + 1).equals("x")){
                    map[i][j] = new wall();
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
                    output += "x";
                } else{
                    output += "o";
                }
            }
            output += "\n";
        }
        return output;
    }

    public static void main(String[] args){
        maze test = new maze();
        System.out.println(test);
    }
    // helper class
    private class coordinate{
        // instance variables
        int xpos;
        int ypos;

        //maze test1 = new maze();
        //maze.coordinate test = test1.new coordinate(1, 2);

        public coordinate(int x, int y){
            xpos = x;
            ypos = y;
        }

        public String toString(){
            return "(" + xpos +", " + ypos +")";
        }
    }


}