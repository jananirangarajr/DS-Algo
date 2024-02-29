package leet.top150;

public class PalindromeNumber9 {
    public static void main(String[] args) {
        int x = 1981;
        System.out.println(isPalindrome(x));
    }
    public static boolean isPalindrome(int x) {
        if ( x < 0)
            return false;
        int n = x;
        int reverseNum = 0;
        while (n > 0) {
            reverseNum = (reverseNum*10)+ (n%10);
            n = n/10;
        }
        return reverseNum == x;
    }
}
