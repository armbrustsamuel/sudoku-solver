import com.sun.tools.javac.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Samuel on 11/04/20.
 */
public class GameHelper {

    public int[][] game_array = new int[9][9];
    public int[][] game_result = new int[9][9];

    public int[][] getGame_array() {
        return game_array;
    }

    public int[][] getGame_result() {
        return game_result;
    }

    public GameHelper() {
        game_result = new int[9][9];
        game_array = new int[9][9];
    }

    /**
     * 534|678|912
     * 672|195|348
     * 198|342|567
     * ---+---+---
     * 859|761|423
     * 426|853|791
     * 713|924|856
     * ---+---+---
     * 961|537|284
     * 287|419|635
     * 345|286|179
     */

    /* to be deprecated */
    public void printEnterArray() {

        for (int i = 0; i < 9; i++) {
            System.out.print(game_array[i][0] + " " + game_array[i][1] + " " + game_array[i][2] + "|");
            System.out.print(game_array[i][3] + " " + game_array[i][4] + " " + game_array[i][5] + "|");
            System.out.print(game_array[i][6] + " " + game_array[i][7] + " " + game_array[i][8]);
            System.out.println();
            if ((i+1) % 3 == 0){
                System.out.print("- - - - - - - - -");
                System.out.println();
            }
        }
    }

    /* to be deprecated */
    public void printResult() {

        for (int i = 0; i < 9; i++) {
            System.out.print(game_result[i][0] + " " + game_result[i][1] + " " + game_result[i][2] + "|");
            System.out.print(game_result[i][3] + " " + game_result[i][4] + " " + game_result[i][5] + "|");
            System.out.print(game_result[i][6] + " " + game_result[i][7] + " " + game_result[i][8]);
            System.out.println();
            if ((i+1) % 3 == 0){
                System.out.print("- - - - - - - - -");
                System.out.println();
            }
        }
    }

    public void printArray(int[][] values) {

        System.out.println("- - - - - - - - -");
        for (int i = 0; i < 9; i++) {
            System.out.print(values[i][0] + " " + values[i][1] + " " + values[i][2] + "|");
            System.out.print(values[i][3] + " " + values[i][4] + " " + values[i][5] + "|");
            System.out.print(values[i][6] + " " + values[i][7] + " " + values[i][8]);
            System.out.println();
            if ((i+1) % 3 == 0){
                System.out.print("- - - - - - - - -");
                System.out.println();
            }
        }
    }

    public void importValues(int[][] values) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                game_array[i][j] = values[i][j];
                game_result[i][j] = values[i][j];
            }
        }

    }

    public Pair<Integer,Integer> get_empty_index(int[][] values) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (values[i][j] == 0 || values[i][j] == '0') {
                    return new Pair(i, j);
                }
            }
        }
        return new Pair(11, 11);
    }

    public void computeAnswer(int[][] values) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                game_result[i][j] = values[i][j];
            }
        }
    }


    public int[][] createGridFromFile(File file) throws FileNotFoundException {

        int[][] grid = new int[9][9];
        List<Character> elementList = new ArrayList<Character>();

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().toString();
            int size = line.length();

            for (int i = 0; i < size; i++) {
                if(line.charAt(i) != '-' &&
                        line.charAt(i) != '|' &&
                        line.charAt(i) != ' ' &&
                        line.charAt(i) != '+') {
                    elementList.add(line.charAt(i));
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (elementList.get(0) == '_'){
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = Integer.parseInt(String.valueOf(elementList.get(0)));
                }
                elementList.remove(0);
            }
        }

        return grid;
    }
}
