package lc399_Evaluate_Division;

import java.util.*;

// LeetCode 399. Evaluate Division
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
        }

        return result;

    }

    private double getPathWeight(String start, String end, Map<String, Map<String, Double>> graph,
            Set<String> visited) {
        if (!graph.containsKey(start)) {
            return -1.0;
        }
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        visited.add(start);
        for (Map.Entry<String, Double> neibor : graph.get(start).entrySet()) {
            if (!visited.contains(neibor.getKey())) {
                double productPath = getPathWeight(neibor.getKey(), end, graph, visited);
                if (productPath != -1.0) {
                    return neibor.getValue() * productPath;
                }
            }
        }
        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String u, v;

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            u = eq.get(0);
            v = eq.get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }

        return graph;
    }
}
