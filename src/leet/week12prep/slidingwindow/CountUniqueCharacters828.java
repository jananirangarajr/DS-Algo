package leet.week12prep.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountUniqueCharacters828 {
    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(uniqueLetterString(s));
    }
    public static int uniqueLetterString(String s) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }
//        for (Map.Entry e : map.entrySet()){
//            System.out.println(e.getValue());
//        }
        for (Map.Entry e : map.entrySet()){
            for (int i = 0; i < ((ArrayList)e.getValue()).size(); i++) {
                int index = (int)((ArrayList) e.getValue()).get(i);
                int leftIndex = index == 0 ? 1 :  i > 0 ? index - (int)((ArrayList) e.getValue()).get(i-1): index+1;
                int rightIndex = i == ((ArrayList)e.getValue()).size()-1? s.length()-index :  (int)((ArrayList) e.getValue()).get(i+1) - index;
                System.out.println(index+" "+leftIndex+" "+rightIndex);
                count+= (leftIndex * rightIndex);
            }
        }
        return count;
    }
}
