package leet.top150;

public class HappyNumber202 {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(HappyNumberSolution.isHappy(n));
    }
}

class HappyNumberSolution {
    public static boolean isHappy(int n) {
        if (n == 1)
            return true;
        else {

            int sum = 0;
            while(n >=1) {
                sum += (n%10) * (n%10);
                n = n/10;
            }
            if ((sum !=7 && sum != 1 )&& sum < 10)
                return false;
            else
                return true && isHappy(sum);
        }
    }
}
