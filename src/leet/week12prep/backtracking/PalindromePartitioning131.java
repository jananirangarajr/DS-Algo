package leet.week12prep.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(partition(s));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        //backtrack(result, new ArrayList<String>(), s, "", 0);
        backtrack(result, new ArrayList<String>(), s, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, ArrayList<String> tempList, String s, int start) {
        if (start == s.length()){
            result.add(new ArrayList<>(tempList));
        }
        else {
            for (int i = start; i < s.length(); i++) {
                if(isPalindrome(s,start,i)){
                    tempList.add(s.substring(start,i+1));//substring end is exclusive
                    backtrack(result,tempList,s,i+1);
                    tempList.remove(tempList.size()-1);//backtrack
                }
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high){
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    private static void backtrack(List<List<String>> result, ArrayList<String> list, String input, String curString, int index){
        /* Initial thought

        if (checkPalindrome(curString)){
            list.add(curString);
        }
        if (index >= input.length())
            return;
        backtrack(result,list,input,input.charAt(index)+"",index+1);
        if (list.size() > 0)
            result.add(new ArrayList<>(list));
        list.clear();
        backtrack(result,list,input, input.charAt(index)+curString,index+1);*/

        /*logic : for every index*/

    }

    private static boolean checkPalindrome(String curString) {
        int i = 0, j = curString.length()-1;
        if (curString == "")
            return false;
        while (i < j){
            if (curString.charAt(i) != curString.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
