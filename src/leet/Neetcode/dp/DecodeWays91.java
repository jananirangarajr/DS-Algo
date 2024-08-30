package leet.Neetcode.dp;

public class DecodeWays91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("12345"));
    }
    public static int numDecodings(String s) {
        return decodings(0,s);
    }
    private static int decodings(int index, String s){
        if (index == s.length())
            return 1;
        if (s.charAt(index) == '0')
            return 0;
        int res = decodings(index+1, s);
        if (index < s.length()-1 && s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index+1) < '7'))
            res += decodings(index+2,s);
        return res;
    }
}
                                                                                                                    