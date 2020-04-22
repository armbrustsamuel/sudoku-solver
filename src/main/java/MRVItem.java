import java.util.Comparator;

/**
 * Created by Samuel on 14/04/20.
 */
public class MRVItem implements Comparator<MRVItem> {
    private int row;
    private int col;
    private int counter;

    public MRVItem(int row, int col, int counter) {
        this.row = row;
        this.col = col;
        this.counter = counter;
    }

    public MRVItem() {

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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public int compare(MRVItem o1, MRVItem o2) {
        return  o1.getCounter() - o2.getCounter();
    }
}
