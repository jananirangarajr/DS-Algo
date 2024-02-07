package leet.top150;

import java.util.HashMap;
import java.util.Map;

public class RansomeNotes383 {
    public static void main(String[] args) {
        String ransomNote = "abc";
        String magazine="ab";
        System.out.println(canConstruct(ransomNote,magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0 ; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i)))
                map.put(magazine.charAt(i), (map.get(magazine.charAt(i))+1));
            else
                map.put(magazine.charAt(i),1);
            if (i < ransomNote.length()) {
                if (map.containsKey(ransomNote.charAt(i)))
                    map.put(ransomNote.charAt(i), (map.get(ransomNote.charAt(i))-1));
                else
                    map.put(ransomNote.charAt(i),-1);
            }
        }
//        return !map.values().stream().anyMatch(s -> s < 0); //takes 25ms to run
        for (Map.Entry<Character, Integer> key : map.entrySet())
            if (key.getValue() < 0)
                return false;
        return true;
    }
}
