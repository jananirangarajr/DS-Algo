package leet.week12prep.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, maxCount = 0;
        int len = s.length();
        /*for (;end<len; end++) {
            char c = s.charAt(end);
            if (!map.containsKey(c)) {
                map.put(c,1);
            }
            else {
                map.put(c,map.get(c)+1);
                char stChar = s.charAt(start);
                while(stChar != c ){
                    map.put(stChar,map.get(stChar)-1);
                    start++;
                    stChar = s.charAt(start);
                }
                if (s.charAt(start) == s.charAt(end)) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    start++;
                }

            }
            maxCount = Math.max(maxCount, end-start+1);
        }
        return maxCount;
        failed for input tmmzuxt
        */
        for (;end<len; end++) {
            char c = s.charAt(end);
            if (!map.containsKey(c)) {
                map.put(c,1);
            }
            else {
                map.put(c,map.get(c)+1);
                while(map.get(s.charAt(end)) != 1){
                    char stChar = s.charAt(start);
                    map.put(stChar,map.get(stChar)-1);
                    start++;
                }
            }
            maxCount = Math.max(maxCount, end-start+1);
        }
        return maxCount;
    }
}
