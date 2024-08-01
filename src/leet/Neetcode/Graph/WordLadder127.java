package leet.Neetcode.Graph;


import java.util.*;

public class WordLadder127 {
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot", "dog"));

        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //construct graph using pattern, the nodes join if it has a single character difference
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashMap<String, List<String>> graph = new HashMap<>();
        //adding beingword to wordList to construct graph
        wordList.add(beginWord);

        for (int i = 0; i < wordList.size(); i++){
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j++){
                String pattern = word.substring(0,j)+"*"+word.substring(j+1,word.length());
                graph.putIfAbsent(pattern,new ArrayList<>());
                graph.get(pattern).add(word);
            }
        }

        //Do BFS to find the mininum no of nodes in path to reach the end word
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visitSet = new HashSet<>();
        queue.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size;i++){
                String word = queue.poll();
                visitSet.add(word);
                if (word.equals(endWord))
                    return level;
                for (int j = 0; j  < word.length(); j++){
                    String pattern = word.substring(0,j)+"*"+word.substring(j+1,word.length());
                    for (int k = 0; k < graph.get(pattern).size(); k++){
                        String neighbourWord = graph.get(pattern).get(k);
                        if (!visitSet.contains(neighbourWord))
                            queue.add(neighbourWord);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
