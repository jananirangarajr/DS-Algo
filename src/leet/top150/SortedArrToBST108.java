package leet.top150;

public class SortedArrToBST108 {
    public static void main(String[] args) {
        int[] nums = new int[] {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        TreeNode.printTree(root);

    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public static TreeNode sortedArrayToBST(int[] nums,int left, int right) {
        if (left > right){
            return null;
        }
        else {
            int mid = (left+right+1)/2;
            TreeNode root = new TreeNode(nums[mid]);
            if (mid-1 >=0) {
                TreeNode leftNode = sortedArrayToBST(nums, left, mid - 1);
                root.left = leftNode;
            }
            if (mid+1 < nums.length){
                TreeNode rightNode = sortedArrayToBST(nums,mid+1,right);
                root.right = rightNode;
            }
            return root;
        }

    }
}
