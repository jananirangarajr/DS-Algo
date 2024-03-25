package leet.week12prep.BinarySearch;

public class Searching2DMatrix74 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length-1;
        int row = 0;
        int colLen = matrix[0].length-1;

        while(top <= bottom){
            int mid = top+(bottom - top)/2;

            if (target>= matrix[mid][0] & target <= matrix[mid][colLen]) {
                row = mid;
                break;
            }
            if (target < matrix[mid][0]){
                bottom = mid-1;
            }
            else
                top = mid+1;
        }

        int left = 0;
        int right = matrix[row].length-1;

        while(left <= right){
            int mid = left+(right-left)/2;
            if (matrix[row][mid] == target)
                return true;
            if (matrix[row][mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return false;
    }
}
