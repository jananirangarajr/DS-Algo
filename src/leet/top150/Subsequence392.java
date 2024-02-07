package leet.top150;

public class Subsequence392 {
    public static void main(String[] args) {
        String s = "ab";
        String t = "bcd";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        if (t.length() == 0)
            return false;
        if (s.length() == 0)
            return true;
        else {
            int i = 0 , j = 0;
            while(i < t.length() && j < s.length()) {
                if(s.charAt(j) == t.charAt(i)) {
                    i++;j++;
                }
                else {
                    i++;
                }
            }
            if (j != s.length())
                return false;
        }
        return true;
    }
}
