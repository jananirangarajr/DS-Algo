package leet.Neetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NQueen51 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
//            for (int j = 0; j < n; j++){
                int[][] board = new int[n][n];
                if (backtrack(board,0,i)){
                    result.add(boardToString(board));
//                }
            }
        }
        return result;
    }
    private static List<String> boardToString(int[][] board){
        List<String> result =  new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            String str = "";
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == 1)
                    str += "Q";
                else
                    str += ".";
            }
            result.add(str);
        }
        return result;
    }
    private static boolean backtrack(int[][] board, int row, int col){
        if (row < 0 || col < 0 || row >= board.length || col >= board.length)
            return false;
        else {
            if (isSafe(board, row, col)){
                System.out.println(row+""+col);
                board[row][col] = 1;
                for(int i = 0; i < board.length; i++){
                     boolean result = backtrack(board, row+1, i);
                     if(result)
                         return result;
                }
                return true;
            }
            else
                return false;
        }
    }

    private static boolean isSafe(int[][] board, int row, int col){
        //check row & column
        for(int i = 0; i < board.length; i++){
            if (board[row][i] == 1 || board[i][col] == 1)
                return false;
        }

        //check diagonal
        //negative diagonal right
        int r = row;
        int c = col;
        while(row >= 0 && row < board.length && col >= 0 && col < board.length){
            if(board[row--][col++] == 1)
                return false;
        }
        row = r;
        col = c;
        //negative diagonal left
        while(row >= 0 && row < board.length && col >= 0 && col < board.length) {
            if(board[row--][col--] == 1)
                return false;
        }
        return true;
    }

}
