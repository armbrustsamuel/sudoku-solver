/**
 * Created by Samuel on 12/04/20.
 */
public class GameRules {

    public boolean isInRow(int[][] grid, int row, int number) {

        for (int col = 0; col < 9; col++) {
            if (grid[row][col] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isInColumn(int[][] grid, int col, int number) {

        for (int row = 0; row < 9; row++) {
            if (grid[row][col] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isInBox(int[][] grid, int begin_row_box, int begin_col_box, int number) {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row + begin_row_box][col + begin_col_box] == number) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isSafeAddTheNumber(int[][] grid, int row, int col, int number) {

        return !isInRow(grid, row, number) && !isInColumn(grid, col, number) && !isInBox(grid, (row - row % 3), (col - col
                % 3), number);

    }

}
