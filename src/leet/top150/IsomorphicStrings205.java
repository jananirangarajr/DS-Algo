package leet.top150;

import java.util.Arrays;
import java.util.List;

public class IsomorphicStrings205 {
    public static void main(String[] args) {
        String s = "bar";
        String t = "foa";
        System.out.println(isIsomorphic(s,t));
    }
    public static boolean isIsomorphic(String s, String t) {
        int[] sArr = new int[256];
        int[] tArr = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (sArr[s.charAt(i)] != tArr[t.charAt(i)])
                return false;
            else{
                sArr[s.charAt(i)]=i+1;
                tArr[t.charAt(i)] = i+1;
            }
        }
        return true;
    }

    private static void printArray(char[] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.println(map[i] + " " + i);
        }
    }
}
