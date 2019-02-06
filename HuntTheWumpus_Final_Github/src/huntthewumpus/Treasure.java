package huntthewumpus;

import huntthewumpus.Constants;
import java.util.Random;

public class Treasure {
    
    private static Treasure getTreasure = new Treasure();
    
    public static Treasure getInstance() {
        return getTreasure;
    }
    
    private Random random = new Random();
    
    private int treasureRow;
    private int treasureColumn;

    public Treasure() {
        treasureRow = random.nextInt(Constants.gridRowSize) + 1;
        treasureColumn = random.nextInt(Constants.gridColumnSize) + 1;
    }
    
    public int returnTreasureRow() {
        return treasureRow;
    }

    public int returnTreasureColumn() {
        return treasureColumn;
    }
    
    public int rerollTreasureRow() {
        treasureRow = random.nextInt(Constants.gridRowSize) + 1;
        return treasureRow;
    }
    
    public int rerollTreasureColumn() {
        treasureColumn = random.nextInt(Constants.gridColumnSize) + 1;
        return treasureColumn;
    }
    
}
