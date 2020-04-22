import com.sun.tools.javac.util.Pair;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Samuel on 12/04/20.
 */
public class GameHelperTest {

    @Test
    public void printResult() throws Exception {

        GameHelper gameHelper = new GameHelper();
        int[][] testValues = new int[9][9];
        for (int i=0 ; i< 70 ;i ++){
            int index1 = (int)(Math.random() * (8 - 0 + 1));
            int index2 = (int)(Math.random() * (8 - 0 + 1));
            int value = (int)(Math.random() * (9 - 0 + 1));
            testValues[index1][index2] = value;
        }

        gameHelper.importValues(testValues);

        gameHelper.printEnterArray();

    }

    @Test
    public void shouldFoundAnEmptyPlace(){

        GameHelper gameHelper = new GameHelper();
        int[][] testValues = new int[9][9];
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
                testValues[i][j] = 3;
            }
        }
        testValues[5][6] = 0;

        assertEquals(gameHelper.get_empty_index(testValues), new Pair(5,6));
    }

    @Test
    public void shouldFoundAnEmptyPlaceIntheBeginningFirst(){

        GameHelper gameHelper = new GameHelper();
        int[][] testValues = new int[9][9];
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++){
                testValues[i][j] = 3;
            }
        }
        testValues[3][2] = 0;
        testValues[2][4] = 0;
        testValues[5][6] = 0;

        assertEquals(gameHelper.get_empty_index(testValues), new Pair(2,4));
    }

}