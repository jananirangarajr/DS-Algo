package leet.week12prep.greedy;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveDuplicateLetters316 {
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }
    public static String removeDuplicateLetters(String s) {

        //bruteforce, find all unique subsets using backtracking, then find the lexographical order
        //optimized solution using monotonic stack and frequency

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        int[] frequency = new int[26];

        for (int i = 0; i < s.length();i++){
            frequency[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited[c - 'a'])
            {
                frequency[c-'a']--;
            }
            else {
                while(!stack.isEmpty() && stack.peek() > c && frequency[stack.peek()-'a'] > 0) {
                    visited[stack.peek()-'a'] = false;
                    stack.pop();
                }
                stack.push(c);
                visited[c-'a'] = true;
                frequency[c-'a']--;
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        return sb.toString();
    }
}
