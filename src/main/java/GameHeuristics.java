import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Samuel on 14/04/20.
 */

/**
 * O jogo de lógica Sudoku: modelagem teórica, NP-completude, algoritmos e heurísticas
 *
 * Available at: http://vigusmao.github.io/manuscripts/sudoku.pdf
 */
public class GameHeuristics {

    public GameRules gameRules;
    public HeuristicObject heuristicObject;

    public GameHeuristics() {
        this.heuristicObject = new HeuristicObject();
        this.gameRules = new GameRules();
    }

    public HeuristicObject getNextSelectedValue(){
        return heuristicObject;
    }

    public void setNextSelectedValue(int[][] grid, int row, int col){
        heuristicObject = new HeuristicObject();
        heuristicObject.setCol(col);
        heuristicObject.setRow(row);
        for (int k = 1; k < 10; k++) {
            if (gameRules.isSafeAddTheNumber(grid, row, col, k)) {
                heuristicObject.getPossibleValues().add(k);
            }
        }
//        System.out.println("Object: " + heuristicObject.toString());
    }

    /*
     Minimum Remaining Values é uma heurística que defende que
     é mais viável selecionar variáveis com menos possibilidades
     de valores. Ou seja, para o Sudoku, significa selecionar a
     célula com menos candidatos a cada vez que for necessário
     atribuir valor a uma nova célula ainda não preenchida.
     */

    public Pair<Integer, Integer> findMRV(int[][] values) {

        List<MRVItem> mrv = new ArrayList<MRVItem>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (values[i][j] == 0) {
                    int count = 0;
                    for (int k = 1; k < 10; k++) {
                        if (gameRules.isSafeAddTheNumber(values, i, j, k)) {
                            count += 1;
                        } else continue;
                    }
                    mrv.add(new MRVItem(i, j, count));
                }
            }
        }

        Collections.sort(mrv, new MRVItem());

        int size = mrv.size();
        if (size == 0) {
            return new Pair<Integer, Integer>(11,11);
        }
//        System.out.println("New values:");
//        for (int i = 0; i < size; i++) {
//            System.out.println("row: " + mrv.get(i).getRow() + " col: " + mrv.get(i).getCol() + " number: " + mrv
//                    .get(i)
//                    .getCounter());
//        }

        if (mrv.get(0).getCounter() != 0){
//            return new Pair<Integer, Integer>(mrv.get(0).getRow(), mrv.get(0).getCol());
            setNextSelectedValue(values, mrv.get(0).getRow(),mrv.get(0).getCol());
            return new Pair<Integer, Integer>(0,0);
        } else {
            return new Pair<Integer, Integer>(12,12);
        }

    }


}
