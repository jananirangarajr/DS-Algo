package leet.top150;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagara";
        Solution solution = new Solution();
        System.out.println(solution.isAnagram(s,t));
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() < t.length())
            return false;
       /* Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
            if (i < t.length()) {
                if (map.containsKey(t.charAt(i)))
                    map.put(t.charAt(i),map.get(t.charAt(i))-1);
                else
                    map.put(t.charAt(i),-1);
            }
        }
        return !map.values().stream().anyMatch(k -> k != 0);*/
        //another approach
        int[] sArray = new int[26];
        for (int i = 0;i <  s.length(); i++) {
            sArray[s.charAt(i)-'a'] += 1;
        }
//        int[] sArray = new int[26];
        for (int i = 0;i <  t.length(); i++) {
            sArray[t.charAt(i)-'a'] -= 1;
        }
        for (int i = 0;i <  s.length(); i++) {
            if (sArray[s.charAt(i)-'a'] != 0)
                return false;
        }
        return true;
    }
}
