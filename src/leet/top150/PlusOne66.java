package leet.top150;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne66 {
    public static void main(String[] args) {
        int[] digits = new int[]{8,9,9,9};
        ArrayList arrayList = new ArrayList(Arrays.asList(plusOne(digits)));
        System.out.println(arrayList);
    }
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        /*if (digits[n-1] < 9) {
            digits[n-1] = digits[n-1]+1;
            return digits;
        }
        else {
            int carry = 1;
            int i = n-1;
            while(carry != 0 && i >= 0) {
                int sum = (digits[i]+carry) %10;
                if (digits[i]+carry < 9)
                    carry = 0;
                else
                    carry = (digits[i]+carry)/10;
                digits[i] = sum;
                i--;

            }
            if (carry != 0 && i == -1) {
                int[] result = new int[n+1];
                result[0] = carry;
                for (i =0; i < n;i++)
                    result[i+1] = digits[i];
                return result;
            }
            return digits;

        }*/
        //another possible solution
        if (digits[n-1] < 9) {
            digits[n-1] = digits[n-1]+1;
            return digits;
        }
        else {
            int carry = 1;
            int i = n-1;
            while(i >= 0) {
                if (digits[i]+carry <= 9){
                    digits[i]= digits[i]++;
                    return digits;
                }
                digits[i] = 0;
                i--;
            }

            int[] result = new int[n+1];
            result[0] = 1;
            return result;
        }
    }
}
