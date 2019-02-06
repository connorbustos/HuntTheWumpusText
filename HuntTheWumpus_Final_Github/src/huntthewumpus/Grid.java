package huntthewumpus;

public class Grid {

    private static Grid getGrid = new Grid();

    public static Grid getInstance() {
        return getGrid;
    }

    private Grid() {
    }

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

    public boolean checkIfSameLocation(int treasureRow, int treasureColumn,
            int wumpusRow, int wumpusColumn) {
        return (treasureRow == wumpusRow && treasureColumn == wumpusColumn);
    }

    private final String closeToTreasure = "You are close to the Treasure!";
    private final String closeToWumpus = "You are close to the Wumpus!";
    private final String notCloseToAnything = "You are not close to the Treasure or the Wumpus.";

    public void checkIfCloseToWumpusOrTreasure(
            int playerRow, int playerColumn,
            int treasureRow, int treasureColumn,
            int wumpusRow, int wumpusColumn) {
        String notifyPlayer = "";

        if ((playerRow + 1 == treasureRow || playerRow - 1 == treasureRow)
                && (playerColumn + 1 == treasureColumn || playerColumn - 1 == treasureColumn)) {
            notifyPlayer = closeToTreasure;
        } else if ((playerRow + 1 == treasureRow || playerRow - 1 == treasureRow)
                && playerColumn == treasureColumn) {
            notifyPlayer = closeToTreasure;
        } else if ((playerColumn + 1 == treasureColumn || playerColumn - 1 == treasureColumn)
                && playerRow == treasureRow) {
            notifyPlayer = closeToTreasure;
        } else if ((playerRow + 1 == wumpusRow || playerRow - 1 == wumpusRow)
                && (playerColumn + 1 == wumpusRow || playerColumn - 1 == wumpusRow)) {
            notifyPlayer = closeToWumpus;
        } else if ((playerRow + 1 == wumpusRow || playerColumn - 1 == wumpusColumn)
                && playerColumn == wumpusColumn) {
            notifyPlayer = closeToWumpus;
        } else if ((playerColumn + 1 == wumpusColumn || playerColumn - 1 == wumpusColumn)
                && playerRow == wumpusRow) {
            notifyPlayer = closeToWumpus;
        }

        if (notifyPlayer.equals(closeToTreasure) || notifyPlayer.equals(closeToWumpus)) {
            System.out.println(notifyPlayer);
        } else {
            System.out.println();
        }

    }

}
