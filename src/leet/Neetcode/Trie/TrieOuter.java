package leet.Neetcode.Trie;

public class TrieOuter {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
    static class Trie {
        char c;
        Trie[] links;
        boolean endChar;
        public Trie() {
            c = '/';
            links = new Trie[26];
        }

        public Trie(char x){
            c = x;
            links = new Trie[26];
        }

        public void insert(String word) {
            Trie t = this;
            for (int i = 0; i < word.length(); i++) {
                char x = word.charAt(i);
                if (t.links[x - 'a'] == null) {
                    t.links[x - 'a'] = new Trie(x);
                }
                t = t.links[x - 'a'];
            }
            t.endChar = true;
        }

        public boolean search(String word) {
            Trie t = this;
            for (int i = 0; i < word.length(); i++){
                char x = word.charAt(i);
                if(t.links[x-'a'] == null)
                    return false;
                t = t.links[x-'a'];
            }
            return t.endChar;
        }

        public boolean startsWith(String prefix) {
            Trie t = this;
            for (int i = 0; i < prefix.length(); i++){
                char x = prefix.charAt(i);
                if(t.links[x-'a'] == null)
                    return false;
                t = t.links[x-'a'];
            }
            return true;
        }
    }

}
