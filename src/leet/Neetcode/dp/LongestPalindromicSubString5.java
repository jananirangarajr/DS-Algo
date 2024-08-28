package leet.Neetcode.dp;

public class LongestPalindromicSubString5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babadabab"));
    }

    public static String longestPalindrome(String s) {
        String result = "";
        int resultLen = 0;
        for (int i = 0; i < s.length(); i++){
            //odd length
            int [] res = isPalindrome(i,i,s);
            if (resultLen < res[1]-res[0]) {
                result = s.substring(res[0],res[1]+1);
                resultLen = res[1]-res[0];
            }
            //even length
            res = isPalindrome(i,i+1,s);
            if (resultLen < res[1]-res[0]) {
                result = s.substring(res[0],res[1]+1);
                resultLen = res[1]-res[0];
            }
        }
        return result;
    }

    private static int[] isPalindrome(int start, int end, String s){
        int[] result = new int[2];
        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            result[0] = start;
            result[1] = end;
            start--;
            end++;
        }
        return result;
    }
}
