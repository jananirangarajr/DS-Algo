package leet.Neetcode.Graph;

public class RedundantConnection684 {
    public static void main(String[] args) {
        int[][] edges = {{3,4},{1,2},{2,4},{3,5},{2,5}};
        int[] result = findRedundantConnection(edges);
        System.out.println(result[0]+" "+result[1]);
    }
    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        //initialize parent values to its same
        for(int i = 0; i < parent.length; i++)
            parent[i]=i;
        int[] rank = new int[edges.length+1];

        for (int i = 0; i < edges.length; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if (!union(n1,n2,parent, rank))
                return edges[i];
        }
        return new int[0];
    }
    private static boolean union(int n1, int n2, int[] parent, int[] rank){

        int n1Parent = find(n1,parent);
        int n2Parent = find(n2,parent);

        if (n1Parent == n2Parent)
            return false;
        if (rank[n1Parent] >= rank[n2Parent]){
            parent[n2Parent] = n1Parent;
            rank[n1Parent] += rank[n2Parent]+1;
        }
        else {
            parent[n1Parent] = n2Parent;
            rank[n2Parent] += rank[n1Parent]+1;
        }
        return true;
    }
    private static int find(int node, int[] parent){
        int p = parent[node];
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }
}
