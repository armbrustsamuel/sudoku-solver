import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Samuel on 15/04/20.
 */
public class SudokuReadFromFile4 {

    public void testReadingFromFile() {

        File file =
                new File("/Users/samuel/Documents/sudoku_game_4.txt");

        GameHelper gameHelper = new GameHelper();
        int[][] grid = new int[0][];
        try {
            grid = gameHelper.createGridFromFile(file);
            gameHelper.printArray(grid);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assertTrue(grid.length != 0);

    }

    @Test
    public void shouldReadFromFileAndSolveWithHeuristics(){
        File file =
                new File("/Users/samuel/Documents/sudoku_game_4.txt");

        GameHelper gameHelper = new GameHelper();
        int[][] grid = new int[0][];
        try {
            grid = gameHelper.createGridFromFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SudokuSolverHeuristics sudokuMRVSolver = new SudokuSolverHeuristics();
        sudokuMRVSolver.importValues(grid);
//        sudokuMRVSolver.printEnteredArray();

        System.out.println("Result with Heuristics:");

        sudokuMRVSolver.solveWithHeuristics(grid);
        sudokuMRVSolver.printResult();

        System.out.println("Nodes: " + sudokuMRVSolver.getNode_count());

    }

    @Test
    public void shouldReadFromFileAndSolveWithoutHeuristics(){

        File file =
                new File("/Users/samuel/Documents/sudoku_game_4.txt");

        GameHelper gameHelper = new GameHelper();
        int[][] grid = new int[0][];
        try {
            grid = gameHelper.createGridFromFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SudokuSolver sudokuDeepSolver = new SudokuSolver();
        sudokuDeepSolver.importValues(grid);

        System.out.println("Result without Heuristics:");

        sudokuDeepSolver.solveWithoutHeuristics(grid);
        sudokuDeepSolver.printResult();

        System.out.println("Nodes: " + sudokuDeepSolver.getNode_count());

    }


}
