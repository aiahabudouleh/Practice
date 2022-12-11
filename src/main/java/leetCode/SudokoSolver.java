package leetCode;

import java.util.HashSet;

public class SudokoSolver {


    public static void main(String[] args) {
        char[][] board = new char[][] {
                 {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> rules = new HashSet<>();
        for (int i=0; i<9 ; ++i) {

            for (int j=0; j<9 ; ++j) {
                char value = board[i][j];
                if (value  != '.') {
                    boolean row = rules.add("Row " + i + ": " + value);
                    boolean col = rules.add("Col " + j + ": " + value);
                    boolean box = rules.add("Box " +  i/3 + ", " + j/3 + ": " + value);
                    if (!row ||
                            !col||
                            !box) {
                        return false ;
                    }

                }
            }
        }

        return true;
    }
}
