package leet.Neetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {
    public static void main(String[] args) {

    }
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map= new HashMap<>();
        return dfs(map,node);
    }
    public Node dfs(Map<Integer,Node> map, Node node){
        if (node == null)
            return null;
        if (!map.containsKey((Integer)node.val)){
            Node copyNode = new Node(node.val);
            map.put(node.val, copyNode);

            for(Node n : node.neighbors){
                Node neighborNode = dfs(map,n);
                copyNode.neighbors.add(neighborNode);
            }
            return copyNode;
        }
        else
            return map.get(node.val);
    }
}
