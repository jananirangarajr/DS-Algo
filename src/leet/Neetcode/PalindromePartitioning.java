package leet.Neetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result,new ArrayList(), s,0,0);
        return result;
    }

    private static void backtrack(List<List<String>> result, List<String> list, String s,int startIndex, int endIndex){
        if(list.size() == s.length() || startIndex == s.length()){
            if(list.size() > 0)
                result.add(new ArrayList(list));
            return;
        }
        else {
            for (int i = startIndex; i < s.length(); i++) {
                String subString = s.substring(startIndex,i+1);
                System.out.println(subString);
                if (isPalindrome(subString)) {
                    list.add(subString);
                    backtrack(result, list, s, i+1, endIndex + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    private static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
