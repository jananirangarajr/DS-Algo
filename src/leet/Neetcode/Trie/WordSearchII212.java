package leet.Neetcode.Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII212 {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain","oathi","oathk","oathf","oate","oathii","oathfi","oathfii"};
        System.out.println(findWords(board,words));

    }
    static class PrefixTrie {
        char c;
        PrefixTrie[] trie;
        String word;
        PrefixTrie(){
            c = '/';
            trie = new PrefixTrie[26];
            word = null;
        }
        PrefixTrie(char x){
            c = x;
            trie = new PrefixTrie[26];
            word = null;
        }

        public void add(String word){
            PrefixTrie ptr = this;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(ptr.trie[c-'a'] == null)
                    ptr.trie[c-'a'] = new PrefixTrie(c);
                ptr = ptr.trie[c-'a'];
            }
            ptr.word = word;
        }
    }
    public static List<String> findWords(char[][] board, String[] words) {
        PrefixTrie pt = new PrefixTrie();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++){
            pt.add(words[i]);
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                if(pt.trie[c-'a'] != null)
                    dfs(board, pt, result, i, j, new boolean[board.length][board[0].length]);
            }
        }
        return result;

    }
    private static void dfs(char[][] board, PrefixTrie pt, List<String> result, int row, int col, boolean[][] visited) {
        if (pt.word != null){
            result.add(pt.word);
            pt.word = null;
            return;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || pt == null || pt.trie[board[row][col]-'a'] == null)
            return;
        visited[row][col] = true;
        dfs(board, pt.trie[board[row][col]-'a'], result, row, col+1, visited);
        dfs(board, pt.trie[board[row][col]-'a'], result, row, col-1, visited);
        dfs(board, pt.trie[board[row][col]-'a'], result, row+1, col, visited);
        dfs(board, pt.trie[board[row][col]-'a'], result, row-1, col, visited);
        visited[row][col] = false;
        return;
    }
}
