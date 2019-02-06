package huntthewumpus;

import java.util.Random;

public class Wumpus {

    private static Wumpus getWumpus = new Wumpus();

    public static Wumpus getInstance() {
        return getWumpus;
    }

    private Random random = new Random();
    
    private int wumpusRow;
    private int wumpusColumn;

    public Wumpus() {
        wumpusRow = random.nextInt(Constants.gridRowSize) + 1;
        wumpusColumn = random.nextInt(Constants.gridColumnSize) + 1;
    }
    
    public int returnWumpusRow() {
        return wumpusRow;
    }

    public int returnWumpusColumn() {
        return wumpusColumn;
    }
    
    public int rerollWumpusRow() {
        wumpusRow = random.nextInt(Constants.gridRowSize) + 1;
        return wumpusRow;
    }
    
    public int rerollWumpusColumn() {
        wumpusColumn = random.nextInt(Constants.gridRowSize) + 1;
        return wumpusColumn;
    }
    
}
