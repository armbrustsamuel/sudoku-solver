import org.junit.Test;

/**
 * Created by Samuel on 14/04/20.
 */
public class SudokuSolverWithHeuristics {

    @Test
    public void solve() throws Exception {

                /*  Example provided by Dra. Patricia
         *   53_|_7_|___
         *   6__|195|___
         *   _98|___|_6_
         *   ------+-------+------
         *   8__|_6_|__3
         *   4__|8_3|__1
         *   7__|_2_|__6
         *   ------+-------+------
         *  _6_|___|28_
         *   ___|419|__5
         *   ___|_8_|_79
         */

        SudokuSolverHeuristics sudokuSolver = new SudokuSolverHeuristics();
        int[][] values = getGameExample();

        // test reason
        sudokuSolver.importValues(values);

        System.out.println();
        System.out.println("Entered array was:");
        sudokuSolver.printEnteredArray();

        sudokuSolver.solveWithHeuristics(values);

        System.out.println();
        System.out.println("Solution is:");

        sudokuSolver.printResult();

    }

    private int[][] getGameExample(){
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
        return testValues;
    }

}
