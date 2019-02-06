package huntthewumpus;

import java.util.Scanner;

public class HuntTheWumpus {

    private static Scanner s = new Scanner(System.in);

    private static Grid gameBoard;
    private static Treasure treasure = Treasure.getInstance();
    private static Wumpus wumpus = Wumpus.getInstance();

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

        while (gameBoard.checkIfSameLocation(
                treasureRow,
                treasureColumn,
                wumpusRow,
                wumpusColumn)) {
            treasureRow = treasure.rerollTreasureRow();
            treasureColumn = treasure.rerollTreasureColumn();
            wumpusRow = wumpus.rerollWumpusRow();
            wumpusColumn = wumpus.rerollWumpusColumn();
        }

        System.out.println("Grid Size: " + Constants.gridRowSize + " by " + Constants.gridColumnSize);
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
                Grid.getInstance().checkIfCloseToWumpusOrTreasure(playerRow, playerColumn, treasureRow, treasureColumn, wumpusRow, wumpusColumn);
            } else if (playerMoveInput.equals("right")) {
                playerColumn += 1;
                if (playerColumn < 0) {
                    System.out.println(lessThanGrid);
                    playerColumn += 1;
                } else if (playerColumn > Constants.gridColumnSize) {
                    System.out.println(greaterThanGrid);
                    playerColumn += -1;
                }
                Grid.getInstance().checkIfCloseToWumpusOrTreasure(playerRow, playerColumn, treasureRow, treasureColumn, wumpusRow, wumpusColumn);
            } else if (playerMoveInput.equals("up")) {
                playerRow += 1;
                if (playerRow < 0) {
                    System.out.println(lessThanGrid);
                    playerRow += -1;
                } else if (playerRow > Constants.gridRowSize) {
                    System.out.println(greaterThanGrid);
                    playerRow += -1;
                }
                Grid.getInstance().checkIfCloseToWumpusOrTreasure(playerRow, playerColumn, treasureRow, treasureColumn, wumpusRow, wumpusColumn);
            } else if (playerMoveInput.equals("down")) {
                playerRow += -1;
                if (playerRow < 0) {
                    System.out.println(lessThanGrid);
                    playerRow += 1;
                } else if (playerRow > Constants.gridRowSize) {
                    System.out.println(greaterThanGrid);
                    playerRow += 1;
                }
                Grid.getInstance().checkIfCloseToWumpusOrTreasure(playerRow, playerColumn, treasureRow, treasureColumn, wumpusRow, wumpusColumn);
            } else {
                System.out.println("You must enter left, right, down, or up to play the game. Nothing happened.");
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
            //Used for debugging. This shouldn't print if the game runs properly. 
            System.out.println("Something went wrong.");
        }
        System.exit(0);

    }

}
