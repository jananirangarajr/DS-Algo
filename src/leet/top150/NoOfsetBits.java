package leet.top150;

public class NoOfsetBits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
    public static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            System.out.println(n +" "+(1 <<i )+" "+(n&i));
            if ((n & (1 << i)) > 0)
                count++;
        }
        return count;
    }
}
