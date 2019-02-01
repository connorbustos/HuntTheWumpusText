package huntthewumpus;

public class Grid {

    private static Grid getGrid = new Grid();

    public static Grid getInstance() {
        return getGrid;
    }

    private Grid() {
    }

    private Treasure treasure = Treasure.getInstance();
    private Wumpus wumpus = Wumpus.getInstance();

    private int gameBoard[][];
    private int gridRowSize, gridColumnSize;

    public Grid(int rowSize, int columnSize) {
        gridRowSize = rowSize;
        gridColumnSize = columnSize;
        gameBoard = new int[gridRowSize][gridColumnSize];
    }

    public void printGrid() {
        for (int row = 0; row < gridRowSize; row++) {
            for (int column = 0; column < gridColumnSize; column++) {
                gameBoard[row][column] = row * column;
                System.out.print("|_");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    private int treasureRowLocation;
    private int treasureColumnLocation;
    private int wumpusRowLocation;
    private int wumupsColumnLocation;

    public void setTreasure(int treasureRow, int treasureColumn) {
        treasureRowLocation = treasureRow;
        treasureColumnLocation = treasureColumn;
    }

    public void setWumpus(int wumpusRow, int wumpusColumn) {
        wumpusRowLocation = wumpusRow;
        wumupsColumnLocation = wumpusColumn;
    }
    
    public boolean checkIfSameLocation(int treasureRow, int treasureColumn,
            int wumpusRow, int wumpusColumn) {
        return (treasureRow == wumpusRow && treasureColumn == wumpusColumn);
    }

}
