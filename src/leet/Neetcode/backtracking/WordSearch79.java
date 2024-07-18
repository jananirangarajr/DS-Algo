package leet.Neetcode.backtracking;

public class WordSearch79 {
    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b', 'c'},
                {'a', 'd', 'f'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0 ; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if(dfs(board, word, i, j,0,visited))
                        return true;
                }
            }
        }
        return false;
    }
    private static boolean dfs(char[][] board, String word, int row, int col,int index, boolean[][] visited){
        if (index >= word.length())
            return true;
        if(board == null || row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || word.charAt(index) != board[row][col] || visited[row][col]){
            return false;
        }
        visited[row][col] = true;
        boolean result =  (dfs(board,word, row, col+1,index+1,visited) || dfs(board,word, row, col-1,index+1,visited) ||
                dfs(board,word, row+1, col,index+1,visited) || dfs(board,word, row-1, col,index+1,visited));
        visited[row][col] = false;
        return result;
    }

}
