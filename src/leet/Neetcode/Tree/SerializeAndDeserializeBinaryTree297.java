package leet.Neetcode.Tree;

import leet.week12prep.Tree.BFS.TreeNode;

import java.util.*;

public class SerializeAndDeserializeBinaryTree297 {
    public static void main(String[] args) {
        String[] array = new String[]{"1","2","3","null","null","4","5"};
        TreeNode root = TreeNode.createTree(array);
        String result = serialize(root);
        System.out.println(result);
        TreeNode node = deserialize(result);
        TreeNode.printInOrderTree(node);

    }
    static String result = "";
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        result = preOrder(root,result);
//        result += "$";
//        result = inOrder(root,result);
        return result;
    }

    private static String preOrder(TreeNode root, String result){
        if (root == null)
            return result+"N,";
        result += root.val+",";
        result = preOrder(root.left,result);
        result = preOrder(root.right,result);
        return result;
    }
    private static String inOrder(TreeNode root, String result){
        if (root == null)
            return result;
        result = inOrder(root.left,result);
        result += root.val+"$";
        result = inOrder(root.right,result);
        return result;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Deque<String> array = new ArrayDeque<>( Arrays.stream(data.split(",")).toList());
        return dfs(array);
//        return null;
    }
    public static TreeNode dfs(Deque<String> array){
        String val = array.remove();
        if (val.equals("N"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = dfs(array);
        root.right = dfs(array);
        return root;
    }
    Comparator c;
    Comparable a;

}