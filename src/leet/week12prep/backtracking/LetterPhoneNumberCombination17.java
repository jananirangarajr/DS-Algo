package leet.week12prep.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterPhoneNumberCombination17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
    public static List<String> letterCombinations(String digits) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> result = new ArrayList<>();
        if(digits.length() == 0)
            return result;
        findCombination(result,map,digits, "",0);
        return result;
    }

    private static void findCombination(List<String> result, HashMap<Integer, String> map, String digits,String currentStr, int index) {
        if (currentStr.length() == digits.length()){
            result.add(currentStr);
            return;
        }
        else{
            int digit = Integer.parseInt(String.valueOf(digits.charAt(index)));
            String s = (String) map.get(digit);
            for(char c : s.toCharArray()){
                findCombination(result,map,digits,(currentStr+c),index+1);
            }
        }
    }
}
