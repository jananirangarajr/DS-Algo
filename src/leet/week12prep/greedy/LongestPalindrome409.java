package leet.week12prep.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome409 {
    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome(s));
    }
    public static int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
            if (map.get(c)%2 == 0){
                count+=2;
            }
        }
        return count%2 == 0 && count < s.length()?count+1:count;
    }
}
