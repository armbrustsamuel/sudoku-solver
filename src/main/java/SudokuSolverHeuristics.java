import com.sun.tools.javac.util.Pair;

/**
 * Created by Samuel on 16/04/20.
 */
public class SudokuSolverHeuristics {

    GameHelper gameHelper;
    GameRules gameRules;
    GameHeuristics gameHeuristics;

    public int getNode_count() {
        return node_count;
    }

    int node_count;

    public SudokuSolverHeuristics() {
        this.gameHelper = new GameHelper();
        this.gameRules = new GameRules();
        this.gameHeuristics = new GameHeuristics();
    }

    public void importValues(int[][] values){
        gameHelper = new GameHelper();
        gameHelper.importValues(values);
    }

    public boolean solveWithHeuristics(int[][] values) {

        Pair<Integer, Integer> pair = gameHeuristics.findMRV(values);
        int row = pair.fst;
        int col = pair.snd;

        if (row == 11 && col == 11) {
            return true;
        }

        if (row == 12 && col == 12) {
            return false;
        }

        node_count +=1;

        HeuristicObject heuristicObject = gameHeuristics.getNextSelectedValue();

//        Enable this code to visualize the step by step
//        System.out.println("Printing partial solution:");
//        gameHelper.printArray(values);
//        System.out.println("Next will be row: " + heuristicObject.getRow() + " and col:" + heuristicObject.getCol());

        for (int obj: heuristicObject.getPossibleValues()) {

            values[heuristicObject.getRow()][heuristicObject.getCol()] = obj;
            gameHelper.computeAnswer(values);

            if (solveWithHeuristics(values)) {
                return true;
            }

            values[heuristicObject.getRow()][heuristicObject.getCol()] = 0;
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
