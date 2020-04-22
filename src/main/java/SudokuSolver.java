import com.sun.tools.javac.util.Pair;

/**
 * Created by Samuel on 12/04/20.
 * Project based on the medium post: https://medium.com/@george.seif94/solving-sudoku-using-a-simple-search-algorithm-3ac44857fee8
 * <p>
 * Some of the following items has been copied from this post:
 * - Recursive strategy - this is the main point
 * - Function to get empty index, returning a pair of data - JAVA has it own Pair() wrapper class, what is very useful
 * - Game rules are very simple, so it can be reused without problem
 * <p>
 * Some items I have added
 * - I added UT for each rule and helper methods, to guarantee they are working as I expect
 * - I separated them into classes to make it easier to test and to compose the final solution
 * - I added a sudoku generator to test if solver works or not
 * - As the example provided by teacher has 30 filled indexes, I generated 30 random numbers in the sudoku to
 * generated grids
 */
public class SudokuSolver {

    GameHelper gameHelper;
    GameRules gameRules;

    public SudokuSolver() {
        this.gameRules = new GameRules();
        this.gameHelper = new GameHelper();
    }

    public void importValues(int[][] values){
        gameHelper = new GameHelper();
        gameHelper.importValues(values);
    }

    public boolean solveWithoutHeuristics(int[][] values) {

        Pair<Integer, Integer> pair = gameHelper.get_empty_index(values);
        int row = pair.fst;
        int col = pair.snd;

        if (row == 11 && col == 11) {
            return true;
        }

//        Enable this code to visualize the step by step
//        System.out.println("Printing partial solution:");
//        gameHelper.printArray(values);
//        System.out.println("Next will be row: " + row + " and col:" + col);

        for (int i = 1; i <= 9; i++) {

            if (gameRules.isSafeAddTheNumber(values, row, col, i)) {
                values[row][col] = i;
                gameHelper.computeAnswer(values);

                if (solveWithoutHeuristics(values)) {
                    return true;
                }

                values[row][col] = 0;
            }
        }

        return false;

    }

    public void printResult() {
        gameHelper.printResult();
    }

    public void printEnteredArray() {
        gameHelper.printEnterArray();
    }
}
