package leet.Neetcode.Graph.AdvancedGraph;

import java.util.*;

public class ReconstructIternary332 {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        String[][] locations = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","JFK"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"},{"ATL","AAA"},{"AAA","BBB"},{"BBB","ATL"}};

        Arrays.stream(locations).forEach(x -> tickets.add(Arrays.asList(x)));
        //sorting helps to keep it in lexicographic order
        Collections.sort(tickets, (List<String>x,List<String>y) -> {
            int result = x.get(0).compareTo(y.get(0));
            if (result == 0)
                return x.get(1).compareTo(y.get(1));
            return result;
        });
        System.out.println(tickets);
        System.out.println(findItinerary(tickets));
    }
    public static List<String> findItinerary(List<List<String>> tickets) {

        //construct graph
        HashMap<String,List<String>> graph = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++){
            String fromLoc = tickets.get(i).get(0);
            String toLoc = tickets.get(i).get(1);
            graph.putIfAbsent(fromLoc, new ArrayList<>());
            graph.putIfAbsent(toLoc, new ArrayList<>());
            graph.get(fromLoc).add(toLoc);
        }

        //always the starting node is JFK, so do dfs with JFK as start node
        HashSet<String> visitSet = new HashSet<String>();
        List<String> result = new ArrayList<>();
        result.add("JFK");
        dfs(graph,"JFK", tickets, result);
        return result;
    }

    private static boolean dfs(HashMap<String, List<String>> graph, String node, List<List<String>> tickets, List<String> result) {
        if(tickets.size()+1 == result.size())
            return true;
        if (!graph.containsKey(node))
            return false;

        List<String>tempList = graph.get(node);
        for (int i = 0; i < tempList.size(); i++){
            String n = tempList.get(i);
            graph.get(node).remove(i);
            result.add(n);
            if(dfs(graph, n, tickets,result))
                return true;
            result.remove(result.size()-1);
            graph.get(node).add(i,n);
        }
        return false;
    }
}
