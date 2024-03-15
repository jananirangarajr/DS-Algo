package leet.week12prep.twopointers;

public class SortColors75 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);
        for(int x : nums)
            System.out.print(x+" ");
    }
    public static void sortColors(int[] nums) {
       /* int countRed = 0;
        int countWhite = 0;
        int countBlue = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++)
        {
            switch (nums[i]){
                case 0:
                    countRed++;
                    break;
                case 1:
                    countWhite++;
                    break;
                case 2:
                    countBlue++;
                    break;
            }
        }
        for (int i =n-1 ; i>=0; i-- ){
            if (countBlue-- > 0)
                nums[i] = 2;
            else if (countWhite-- > 0)
                nums[i] = 1;
            else if (countRed-- > 0) {
                nums[i] = 0;
            }

        }
        2 pass solution
        */
        int n = nums.length;
        int i = 0;
        int left = 0;
        int right = n-1;
        while (i < right) {
            if (nums[i] == 0){
                swap(i,left,nums);
                left++;
                i++;
            }
            else if (nums[i] == 2){
                swap(i,right,nums);
                right--;
            }
            else
                i++;
        }
    }
    private static void swap(int index1, int index2, int[] nums){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
