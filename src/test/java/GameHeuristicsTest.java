import org.junit.Test;

/**
 * Created by Samuel on 14/04/20.
 */
public class GameHeuristicsTest {
    @Test
    public void findMRV() throws Exception {

        GameHeuristics gameHeuristics = new GameHeuristics();
        int[][] testValues = new int[9][9];
        testValues[0][0] = 5;
        testValues[0][1] = 3;
        testValues[0][4] = 7;
        testValues[1][0] = 6;
        testValues[1][4] = 1;
        testValues[1][5] = 9;
        testValues[1][6] = 5;
        testValues[2][1] = 9;
        testValues[2][2] = 8;
        testValues[2][7] = 6;
        testValues[3][0] = 8;
        testValues[3][4] = 6;
        testValues[3][8] = 3;
        testValues[4][0] = 4;
        testValues[4][3] = 8;
        testValues[4][5] = 3;
        testValues[4][8] = 1;
        testValues[5][0] = 7;
        testValues[5][4] = 2;
        testValues[5][8] = 6;
        testValues[6][1] = 6;
        testValues[6][6] = 2;
        testValues[6][7] = 8;
        testValues[7][3] = 4;
        testValues[7][4] = 1;
        testValues[7][5] = 9;
        testValues[7][8] = 5;
        testValues[8][4] = 8;
        testValues[8][7] = 7;
        testValues[8][8] = 9;

        gameHeuristics.findMRV(testValues);

    }

}