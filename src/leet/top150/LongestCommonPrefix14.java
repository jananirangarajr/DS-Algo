package leet.top150;

import java.util.Arrays;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strs = new String[] {
                "flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length-1;
        String result = "";
        for (int i = 0; i < Math.min(strs[0].length(),strs[n].length()); i++) {
            if (strs[0].charAt(i) != strs[n].charAt(i))
                break;
            result+= strs[0].charAt(i);
        }
        return result;
    }
}
