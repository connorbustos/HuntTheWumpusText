package huntthewumpus;

import java.util.Scanner;

public class HuntTheWumpus {

    private static Grid gameBoard;
//    private static Player player = new Player(Constants.playerStartingRow, Constants.playerStartingColumn);
    private static Treasure treasure = Treasure.getInstance();
    private static Wumpus wumpus = Wumpus.getInstance();
    private static Scanner s = new Scanner(System.in);

    public HuntTheWumpus() {

    }

    public void runGame() {

        boolean setOpenLoop = true;

        String lessThanGrid = "You can't move less than 0!";
        String greaterThanGrid = "You can't move past " + Constants.gridColumnSize;

        int playerRow = Constants.playerStartingRow;
        int playerColumn = Constants.playerStartingColumn;

        int treasureRow = treasure.returnTreasureRow();
        int treasureColumn = treasure.returnTreasureColumn();
        int wumpusRow = wumpus.returnWumpusRow();
        int wumpusColumn = wumpus.returnWumpusColumn();

        gameBoard = new Grid(Constants.gridRowSize, Constants.gridColumnSize);

        if (gameBoard.checkIfSameLocation(
                treasure.returnTreasureRow(),
                treasure.returnTreasureColumn(),
                wumpus.returnWumpusRow(),
                wumpus.returnWumpusColumn())) {
            System.out.println("They are the same");
        } else {
            System.out.println("Treasure Row: " + treasure.returnTreasureRow());
            System.out.println("Treasure Column: " + treasure.returnTreasureColumn());
            System.out.println();
            System.out.println("Wumpus Row: " + wumpus.returnWumpusRow());
            System.out.println("Wumpus Column: " + wumpus.returnWumpusColumn());
        }

        System.out.println("Controls: type left, right, up, down");
        String playerMoveInput;

        while (setOpenLoop) {
            System.out.println();
            System.out.println("Player at " + playerRow + ", " + playerColumn);
            System.out.println("Where would you like to move your character?");
            playerMoveInput = s.next();
            if (playerMoveInput.equals("left")) {
                playerColumn += -1;
                if (playerColumn < 0) {
                    System.out.println(lessThanGrid);
                    playerColumn += 1;
                } else if (playerColumn > Constants.gridColumnSize) {
                    System.out.println(greaterThanGrid);
                    playerColumn -= 1;
                }
            } else if (playerMoveInput.equals("right")) {
                playerColumn += 1;
                if (playerColumn < 0) {
                    System.out.println(lessThanGrid);
                    playerColumn += 1;
                } else if (playerColumn > Constants.gridColumnSize) {
                    System.out.println(greaterThanGrid);
                    playerColumn += -1;
                }
            } else if (playerMoveInput.equals("up")) {
                playerRow += 1;
                if (playerRow < 0) {
                    System.out.println(lessThanGrid);
                    playerRow += -1;
                } else if (playerRow > Constants.gridRowSize) {
                    System.out.println(greaterThanGrid);
                    playerRow += -1;
                }
            } else if (playerMoveInput.equals("down")) {
                playerRow += -1;
                if (playerRow < 0) {
                    System.out.println(lessThanGrid);
                    playerRow += 1;
                } else if (playerRow > Constants.gridRowSize) {
                    System.out.println(greaterThanGrid);
                    playerRow += 1;
                }
            }

            //Check if Player is at Wumpus/Treasure. If so, stops the loop. 
            if (playerRow == treasureRow && playerColumn == treasureColumn
                    || playerRow == wumpusRow && playerColumn == wumpusColumn) {
                setOpenLoop = false;
            }

        }

        if (playerRow == treasureRow && playerColumn == treasureColumn) {
            System.out.println("You win!");
        } else if (playerRow == wumpusRow && playerColumn == wumpusColumn) {
            System.out.println("You lose!");
        } else {
            System.out.println("Something went wrong");
        }
        System.exit(0);

    }

}
