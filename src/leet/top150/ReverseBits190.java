package leet.top150;

public class ReverseBits190 {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
    public static int reverseBits(int n) {
        /*StringBuilder result = new StringBuilder();
        while(n>0) {
            result.append(n%2);
            n = n/2;
        }
        if (result.length() < 32) {
            result = new StringBuilder(32-result.length()).insert()
        }
        int sum = 0;
        int i = result.length();
        int j = 0;
        while(i >=0) {
            sum += (result.charAt(i)-'0')*2^j;
            i--;
            j++;
        }
        return sum;*/

        int result = 0;
        for (int i = 0; i <= 32; i++) {
            result = result << 1;
            if ((n & 1) == 1) {
                result += 1;
            }
            n = n >> 1;
        }
        return result;
    }
}
