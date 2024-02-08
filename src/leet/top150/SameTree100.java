package leet.top150;

public class SameTree100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode();
//        p.val =1;
        TreeNode q = new TreeNode();
//        q.val = 0;
        System.out.println(isSameTree(p,q));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p != null && q == null) || (p == null && q != null))
            return false;
        else {
            if (p.val == q.val)
                return true && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
