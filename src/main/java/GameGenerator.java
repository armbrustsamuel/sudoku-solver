/**
 * Created by Samuel on 12/04/20.
 */
public class GameGenerator {

    public int[][] grid;
    public GameRules gameRules;

    public GameGenerator() {
        this.grid = new int[9][9];
        this.gameRules = new GameRules();
    }

    public void generateGame(){
        for (int i=0 ; i< 40 ;i ++) {
            int index1 = (int) (Math.random() * (8 - 0 + 1));
            int index2 = (int) (Math.random() * (8 - 0 + 1));
            int value = (int) (Math.random() * (9 - 1 + 1)+1);
            if (gameRules.isSafeAddTheNumber(grid,index1,index2, value)) {
                grid[index1][index2] = value;
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

}
