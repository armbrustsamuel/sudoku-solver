import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel on 16/04/20.
 */
public class HeuristicObject {

    List<Integer> possibleValues = new ArrayList<Integer>();
    int row;
    int col;

    public HeuristicObject() {
    }

    public HeuristicObject(List<Integer> possibleValues, int row, int col) {
        this.possibleValues = possibleValues;
        this.row = row;
        this.col = col;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(List<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "HeuristicObject{" +
                "possibleValues=" + possibleValues +
                ", row=" + row +
                ", col=" + col +
                '}';
    }
}
