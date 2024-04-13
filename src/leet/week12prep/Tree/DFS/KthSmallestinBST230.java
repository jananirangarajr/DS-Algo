package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

import java.util.Stack;

public class KthSmallestinBST230 {
    public static void main(String[] args) {
        String[] nodes = new String[] {"5","3","6","2","4","null","null","1"};
        TreeNode root = TreeNode.createTree(nodes);
//        TreeNode.printInOrderTree(root);
        int k = 3;
        int ele = kthSmallest(root,k);
        System.out.println(ele);

    }
    public static int kthSmallest(TreeNode root, int k) {
//        return kthSmallest(root,k, 0);
        /*
        if (root == null)
            return 0;
        else {
            int left = kthSmallest(root.left,k);
            if (left != 0)
                return left;
            k = k-1;
            if (k == 0)
                return root.val;
            int right = kthSmallest(root.right,k);
            return right;
        }
        */
        //stack based approach
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        while( k != 0){
            TreeNode s = stack.pop();
            k--;
            if (k == 0)
                return s.val;
            TreeNode right = s.right;
            while(right != null){
                stack.push(right);
                right = right.left;
            }
        }
        return 0;
    }

    private static int kthSmallest(TreeNode root, int k, int count) {
        if (root == null)
            return 0;
        else {
            int left = kthSmallest(root.left,k,count);
            if (left != 0)
                return left;
            count = count +1; // for root
            if (count == k)
                return root.val;
            kthSmallest(root.right,k,count+1);
        }
        return 0;
    }
}
