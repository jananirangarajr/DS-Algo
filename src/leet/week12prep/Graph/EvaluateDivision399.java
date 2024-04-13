package leet.week12prep.Graph;

import java.util.*;

public class EvaluateDivision399 {
    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","c"));
        equations.add(Arrays.asList("b","c"));

        double[] values = {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","a"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));

        double[] result = calcEquation(equations,values,queries);

        for (double v : result) {
            System.out.println(v);
        }

    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
        form a graph, with numberator to denominator for the equations with the values
        for every queries, find if the path exists, if not return -1, else, multiply the weights and return
        a/b = 2  b/c = 3 => a/c = a/b(2) * b/c (3) = 6
        c/a = inverse of a/b * b/c => b/a * c/b = 1/2 * 1/3 = 1/6
         */

        //form graph
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> nodes = equations.get(i);

            graph.putIfAbsent(nodes.get(0),new HashMap<>()); // forward edge
            graph.putIfAbsent(nodes.get(1),new HashMap<>()); //backward edge
            graph.get(nodes.get(0)).put(nodes.get(1), values[i]);
            graph.get(nodes.get(1)).put(nodes.get(0),(double) 1/values[i]);
        }
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            result[i] = dfs(src,target,1, new HashSet<>(),graph);
        }
        return result;
    }

    private static double dfs(String src, String target, double product, HashSet<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(src))
            return -1;
        if (src.equals(target))
            return product;

        visited.add(src);
        for (Map.Entry<String, Double> entry : graph.get(src).entrySet()){
            if (visited.contains(entry.getKey()))
                continue;
            double res = dfs(entry.getKey(),target,product*entry.getValue(), visited, graph);
            if (res != -1) //value found
                return res;
        }
        return -1;
    }
}
