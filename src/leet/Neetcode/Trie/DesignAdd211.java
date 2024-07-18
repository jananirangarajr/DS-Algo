package leet.Neetcode.Trie;

public class DesignAdd211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.addWord("bat");
        System.out.println( wordDictionary.search(".at")); // return False
        System.out.println(wordDictionary.search(".")); // return True
        System.out.println(wordDictionary.search("aa")); // return True
        System.out.println(wordDictionary.search(".a")); // return True
        System.out.println(wordDictionary.search("a.")); // return True
    }

    static class WordDictionary {
        WordDictionary[] wd;
        char c;
        boolean word;
        public WordDictionary() {
            wd = new WordDictionary[127];
            c = '/';
            word = false;
        }
        public WordDictionary(char x){
            wd = new WordDictionary[127];
            this.c = x;
        }

        public void addWord(String word) {
            WordDictionary w = this;
            for (int i = 0; i < word.length(); i++)
            {
                char x = word.charAt(i);
                if(w.wd[x] == null){
                    w.wd[x] = new WordDictionary(x);
                }
                w = w.wd[x];
            }
            w.word = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, this);
        }
        private boolean dfs(String word, int index, WordDictionary cur){

            for (int i = index; i < word.length(); i++){
                char x = word.charAt(i);
                if(x == '.'){
                    for (int j = 0; j < 127; j++) {
                        if(cur.wd[j] != null)
                            if(dfs(word, i + 1, cur.wd[j]))
                                return true;
                    }
                    return false;
                }
                else {
                    if (cur.wd[x] ==null)
                        return false;
                }
                cur = cur.wd[x];
            }
            return cur.word;
        }
    }
}
