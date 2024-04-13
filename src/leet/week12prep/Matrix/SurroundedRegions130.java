package leet.week12prep.Matrix;

public class SurroundedRegions130 {
    public static void main(String[] args) {
        /*
        * logic : convert the border O to T, Do dfs for all the border found O
        * change the remaining O to X
        * Change the T to O
        * */
        char[][] board = {
                { 'X', 'O', 'X' },
                { 'X', 'O', 'X' },
                { 'X', 'X', 'X' },
                { 'X', 'O', 'X' },
                { 'X', 'X', 'X' },
                { 'X', 'O', 'X' },
        };
        solve(board);
        for (char[] x: board){
            for (char c : x) {
                System.out.print(c+" ");
            }
            System.out.println();
        }

    }
    public static void solve(char[][] board) {

        /*
         * logic : convert the border O to T, Do dfs for all the border found O
         * change the remaining O to X
         * Change the T to O
         * */
        int[] rowBoarder = {0, board.length-1};
        int[] colBorder = {0, board[0].length-1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((j == colBorder[0] || j == colBorder[1])  || (i == rowBoarder[0] || i == rowBoarder[1])) {
                    if (board[i][j] == 'O')
                        dfs(i,j,board);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    private static void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i  >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'T')
            return;
        else{
            board[i][j] = 'T';
            dfs(i-1,j,board);
            dfs(i+1,j,board);
            dfs(i,j-1,board);
            dfs(i,j+1,board);
        }
    }
}
