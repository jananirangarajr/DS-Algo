package leet.Neetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak139 {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("leet");
        wordList.add("code");
        System.out.println(wordBreak("leetcode",wordList));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        /*
        failed for logic s = cars, wordList = car,ca,rs
        HashMap<Character, List<String>> wordMap = constructMap(wordDict);
        int start = 0;

        while (start < s.length()){
            if (wordMap.get(s.charAt(start)) == null){
                return false;
            }
            for (String str : wordMap.get(s.charAt(start))){
                int len = str.length();
                if (start+len > s.length())
                    return false;
                String subString = s.substring(start,start+len);
                System.out.println(subString+" "+start);
                if (str.equals(subString)){
                    start = start+len;
                    break;
                }
            }
        }
        return true;*/
        //decision making : check every wordlist for every i+wordlist(i).length - dp bottom up approach

        boolean[] dp = new boolean[s.length()+1];
        int start = s.length()-1;
        dp[s.length()] = true;

        for (;start >=0; start--) {
            for (String str : wordDict){
                if(start+str.length() <= s.length() && s.substring(start,start+str.length()).equals(str))
                    dp[start] = dp[start+str.length()];
                if(dp[start])
                    break;
            }
        }
        return dp[0];
    }

    private static HashMap<Character, List<String>> constructMap(List<String> wordDict){
        HashMap<Character, List<String>> result = new HashMap<>();

        for (String s : wordDict) {
            result.putIfAbsent(s.charAt(0),new ArrayList<String>());
            result.get(s.charAt(0)).add(s);
        }
        return result;
    }
}
