package leet.Neetcode.dp;

public class PlaindromicSubStrings647 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abba"));
    }
    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++){
            count+=isPalindrome(i, i, s);
            count += isPalindrome(i, i+1, s);
        }
        return count;
    }

    private static int isPalindrome (int start, int end, String s){
        int result = 0;

        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            result++;
            start--;
            end++;
        }
        return result;
    }
}
