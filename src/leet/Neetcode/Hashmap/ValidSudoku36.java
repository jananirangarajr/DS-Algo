package leet.Neetcode.Hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku36 {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
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
        Map<Integer, HashSet<Character>> rowMap = new HashMap<>();
        Map<Integer, HashSet<Character>> colMap = new HashMap<>();
        Map<Integer, Map<Integer,HashSet<Character>>> diagonalMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    rowMap.putIfAbsent(i, new HashSet<>());
                    colMap.putIfAbsent(j, new HashSet<>());
                    Set<Character> rowSet = rowMap.get(i);
                    Set<Character> colSet = colMap.get(j);
                    if (!(rowSet.add(board[i][j]) && colSet.add(board[i][j])))
                        return false;
                    int diagRow = i / 3;
                    int diagCol = j / 3;
                    diagonalMap.putIfAbsent(diagRow, new HashMap<>());
                    diagonalMap.get(diagRow).putIfAbsent(diagCol, new HashSet<>());
                    if (!diagonalMap.get(diagRow).get(diagCol).add(board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }
}
