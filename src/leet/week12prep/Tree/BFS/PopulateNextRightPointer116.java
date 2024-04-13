package leet.week12prep.Tree.BFS;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class PopulateNextRightPointer116 {


    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node (6);
        Node result = connect(root);

        while(result != null) {
            System.out.println(root + " " + root.left + " " + root.right + " " + root.next);
            root = root.left;
        }

    }
    public static Node connect(Node root) {
        /*if (root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                Node n = queue.poll();
                if (i != level-1 && !queue.isEmpty())
                    n.next = queue.peek();
                if (n.left != null)
                    queue.add(n.left);
                if (n.right != null)
                    queue.add(n.right);
            }
        }
        return root;*/
        Node current = root;
        Node next = root != null? root.left: null;
        while(current != null && next != null) {

            if (current.left != null)
            {
                if (current.right != null)
                    current.left.next = current.right;
                else if (current.next.left != null)
                    current.left.next = current.next.left;
                else
                    current.left.next = current.next.right;
            }
            else if (current.right != null)
            {
                 if (current.next.left != null)
                    current.right.next = current.next.left;
                else
                    current.right.next = current.next.right;
            }

//            current.left.next = current.right;
//            if (current.next != null)
//                current.right.next = current.next.left;

            current = current.next;
            if (current == null)
                current = next;
                next = current.left;
        }
        return root;
    }
}
