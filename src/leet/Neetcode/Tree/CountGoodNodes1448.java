package leet.Neetcode.Tree;

import leet.week12prep.Tree.BFS.TreeNode;

import java.util.Stack;

public class CountGoodNodes1448 {
    public static void main(String[] args) {
        String[] array = {"3","1","4","3","1","5"};
        TreeNode root = TreeNode.createTree(array);
        System.out.println(goodNodes(root));
;    }
    int count = 0;
    public static int goodNodes(TreeNode root) {
        /**
         Works fine, Space complexity - extra space for stack
         */
        // Stack<TreeNode> stack = new Stack();
        // goodNodes(root,stack);
        // return count;
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode root, int maxValue){
        if (root == null)
            return 0;
        int result = root.val >= maxValue ? 1 : 0;
        maxValue = Math.max(root.val,maxValue);
        result += dfs(root.left, maxValue);
        result += dfs(root.right, maxValue);
        return result;
    }

    private void goodNodes(TreeNode root, Stack<TreeNode> stack){
        if (root == null)
            return;
        if (stack.isEmpty()){
            stack.push(root);
        }
        if (root.val >= stack.peek().val){
            stack.push(root);
            count++;
        }

        goodNodes(root.left,stack);
        goodNodes(root.right,stack);
        if(!stack.isEmpty()){
            if (stack.peek() == root.right)
                stack.pop();
            if (stack.peek() == root.left)
                stack.peek();
            if (stack.peek() == root)
                stack.pop();
        }
    }
}
