package algo.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int nums[] = new int[] {4,8,1,2,0,4,7,3,9,5};
        int key = 5;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key){
                System.out.println(i);
                break;
            }
        }

    }
}
