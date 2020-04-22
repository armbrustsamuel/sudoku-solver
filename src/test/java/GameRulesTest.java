import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Samuel on 12/04/20.
 */
public class GameRulesTest {


    /* 0,0 0,1 0,2 | 0,3 0,4 0,5 | 0,6 0,7 0,8 |
     * 1,0 1,1 1,2 | 1,3 1,4 1,5 | 1,6 1,7 1,8 |
     * 2,0 2,1 2,2 | 2,3 2,4 2,5 | 2,6 2,7 2,8 |
     *  ----------   -----------   -----------
     * 3,0 3,1 3,2 | 3,3 3,4 3,5 | 3,6 3,7 3,8 |
     * 4,0 4,1 4,2 | 4,3 4,4 4,5 | 4,6 4,7 4,8 |
     * 5,0 5,1 5,2 | 5,3 5,4 5,5 | 5,6 5,7 5,8 |
     *  ----------   -----------   -----------
     */

    @Test
    public void shoudlReturnTrueWhen5ExistsInTheRow() throws Exception {
        GameRules gameRules = new GameRules();
        int[][] testValues = new int[9][9];
        testValues[3][4] = 5;
        assertEquals(gameRules.isInRow(testValues,3,5),true);
    }

    @Test
    public void shoudlReturnTrueWhen5ExistsInTheColumn() throws Exception {
        GameRules gameRules = new GameRules();
        int[][] testValues = new int[9][9];
        testValues[3][4] = 5;
        assertEquals(gameRules.isInColumn(testValues,4,5),true);
    }

    @Test
    public void shoudlReturnTrueWhen2ExistsInTheBox() throws Exception {
        GameRules gameRules = new GameRules();
        int[][] testValues = new int[9][9];
        testValues[1][4] = 2;
        assertEquals(gameRules.isInBox(testValues, 2 - 2 % 3, 5 - 5 % 3, 2), true);
    }

    @Test
    public void shoudReturnTrueWhenEnter5IsSafe() throws Exception {
        GameRules gameRules = new GameRules();
        int[][] testValues = new int[9][9];
        testValues[0][3] = 3;
        testValues[0][4] = 4;
        testValues[0][5] = 5;
        testValues[1][3] = 6;
        testValues[1][4] = 1;
        testValues[1][5] = 7;
        testValues[2][4] = 8;
        testValues[2][5] = 9;

        assertEquals(gameRules.isSafeAddTheNumber(testValues, 2, 3, 2), true);
    }

    @Test
    public void shoudReturnFalseWhenEnter2IsInTheBox() throws Exception {
        GameRules gameRules = new GameRules();
        int[][] testValues = new int[9][9];
        testValues[0][3] = 3;
        testValues[0][4] = 4;
        testValues[0][5] = 5;
        testValues[1][3] = 6;
        testValues[1][4] = 1;
        testValues[1][5] = 7;
        testValues[2][3] = 2;
        testValues[2][4] = 8;
        testValues[2][5] = 9;

        assertEquals(gameRules.isSafeAddTheNumber(testValues, 2, 3, 2), false);
    }

    @Test
    public void shoudReturnFalseWhenEnter2IsInTheRow() throws Exception {
        GameRules gameRules = new GameRules();
        int[][] testValues = new int[9][9];
        testValues[2][1] = 3;
        testValues[2][2] = 4;
        testValues[2][3] = 5;
        testValues[2][4] = 6;
        testValues[2][5] = 1;
        testValues[2][6] = 7;
        testValues[2][7] = 2;
        testValues[2][8] = 8;
        testValues[2][0] = 9;

        assertEquals(gameRules.isSafeAddTheNumber(testValues, 2, 3, 2), false);
    }

    @Test
    public void shoudReturnFalseWhenEnter2IsInTheColumn() throws Exception {
        GameRules gameRules = new GameRules();
        int[][] testValues = new int[9][9];
        testValues[1][3] = 3;
        testValues[2][3] = 4;
        testValues[3][3] = 5;
        testValues[4][3] = 6;
        testValues[5][3] = 1;
        testValues[6][3] = 7;
        testValues[7][3] = 2;
        testValues[8][3] = 8;
        testValues[0][3] = 9;

        assertEquals(gameRules.isSafeAddTheNumber(testValues, 2, 3, 2), false);
    }

}