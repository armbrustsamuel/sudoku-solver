import org.junit.Test;

/**
 * Created by Samuel on 12/04/20.
 */
public class GameGeneratorTest {

    @Test
    public void shouldGenerateAValidGridWithoutViolatingConstraints() throws Exception {
        GameGenerator gameGenerator = new GameGenerator();
        gameGenerator.generateGame();
        int[][] game = gameGenerator.getGrid();

        GameHelper gameHelper = new GameHelper();
        gameHelper.printArray(game);
    }

    @Test
    public void shouldResolveThePuzzleWithGeneratedScenario() {
        GameGenerator gameGenerator = new GameGenerator();
        gameGenerator.generateGame();
        int[][] game = gameGenerator.getGrid();

        GameHelper gameHelper = new GameHelper();
        System.out.println();
        System.out.println("Entered array was:");
        gameHelper.printArray(game);

        SudokuSolver sudokuSolver = new SudokuSolver();
        if (sudokuSolver.solveWithoutHeuristics(game)) {
            System.out.println();
            System.out.println("The solution is:");
            sudokuSolver.printResult();
        } else {
            System.out.println("Cannot solveWithoutHeuristics this puzzle");
        }
    }

    @Test
    public void shouldResolveThePuzzleWithHeuristicsInGeneratedScenario() {
        GameGenerator gameGenerator = new GameGenerator();
        gameGenerator.generateGame();
        int[][] game = gameGenerator.getGrid();

        GameHelper gameHelper = new GameHelper();
        System.out.println();
        System.out.println("Entered array was:");
        gameHelper.printArray(game);

        SudokuSolverHeuristics sudokuSolver = new SudokuSolverHeuristics();
        if (sudokuSolver.solveWithHeuristics(game)) {
            System.out.println();
            System.out.println("The solution is:");
            sudokuSolver.printResult();
        } else {
            System.out.println("Cannot solveWithoutHeuristics this puzzle");
        }
    }

    @Test
    public void shouldReturnBothResultsFromAGeneratedGrid() {
        GameGenerator gameGenerator = new GameGenerator();
        gameGenerator.generateGame();
        int[][] grid1 = gameGenerator.getGrid();
        int[][] grid2 = grid1.clone();

        solveWithoutHeuristics(grid2);

        solveWithHeuristics(grid1);
    }

    private int[][] solveWithHeuristics(int[][] values) {

        SudokuSolverHeuristics sudokuMRVSolver = new SudokuSolverHeuristics();

        sudokuMRVSolver.importValues(values);

        System.out.println("Result with Heuristics:");
        sudokuMRVSolver.printEnteredArray();
        sudokuMRVSolver.solveWithHeuristics(values);
        sudokuMRVSolver.printResult();

        return values;

    }

    private int[][] solveWithoutHeuristics(int[][] values) {

        SudokuSolver sudokuDeepSolver = new SudokuSolver();

        sudokuDeepSolver.importValues(values);

        System.out.println();
        System.out.println("Result without Heuristics:");
        sudokuDeepSolver.printEnteredArray();
        sudokuDeepSolver.solveWithoutHeuristics(values);
        sudokuDeepSolver.printResult();

        return values;

    }

}