package leet.week12prep.backtracking;


public class SudokoSolver37 {
    public static void main(String[] args) {
        char[][] board = new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        display(board);
    }

    private static void display(char[][] board) {
        for (char[] x : board ) {
            for (char c : x)
                System.out.print(c+" ");
            System.out.println();
        }
    }

    public static boolean solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++){
                    if (isSafe(board, num, i, j)) {
                        board[i][j] = num;
                        if (solveSudoku(board)){
                            return true;
                        }
                        board[i][j] = '.'; //backtrack
                    }
                }
                return false;
            }
        }
        return true;
    }

    /*private static void sudoko(char[][] board, int col,int row, char number,char[][] result)
    {
        System.out.println(row+" "+col);
        if (row == 8 && col == 8)
        {
            display(board);
            result = board.clone();
        }
        for (int i = 0; i <9; i++) {
            if (board[i][col] != '.') continue;
            if (isSafe(board, number, col, i)) {
                board[i][col] = number;
                sudoko(board,col+1,i,number,result);
                board[i][col] = '.';
            }
            //col++;

        }
    }*/

    private static boolean isSafe(char[][] board, char number, int col, int row) {
        int rowBlock = (row/3)*3;
        int colBlock = (col/3)*3;
        for (int i = 0 ; i < 9; i++){
            if (board[i][row] == number || board[col][i] == number)
                return false;
            if (board[rowBlock+i/3][colBlock+i%3]==number)
                return false;
        }
        //should not be in the 3*3 range
        return true;
    }
}
