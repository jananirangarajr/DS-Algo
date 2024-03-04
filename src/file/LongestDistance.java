package file;

public class LongestDistance {

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,7,4};
//        int[] nums = new int[] {2, 6, 6, 3, 7};
        System.out.println(solution(nums));
    }
    public static int solution(int[] blocks) {
        int n = blocks.length;
        int maxDistance = 1; // Initialize with a minimum possible value

        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;

            // Move left
            while (left > 0 && blocks[left - 1] >= blocks[left]) {
                left--;
            }

            // Move right
            while (right < n - 1 && blocks[right + 1] >= blocks[right]) {
                right++;
            }

            // Update max distance
            maxDistance = Math.max(maxDistance, right - left + 1);
        }

        return maxDistance;
    }
}
