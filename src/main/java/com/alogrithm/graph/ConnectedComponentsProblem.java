package com.alogrithm.graph;

import java.util.*;

public class ConnectedComponentsProblem {

    public static int largestComponent(Map<Integer, List<Integer>> graph){
        int largestCount = Integer.MIN_VALUE;

        Set<Integer> visited = new HashSet<>();

        for(Integer node : graph.keySet()){
            int count = getComponentCount(graph, node, visited);
            if(largestCount < count){
                largestCount = count;
            }
        }

        return largestCount;
    }

    private static int getComponentCount(Map<Integer, List<Integer>> graph, Integer current, Set<Integer> visited) {

        if(visited.contains(current))
            return 0;

        int count = 1;

        for(Integer neighbor : graph.get(current)){
            visited.add(current);
            if(! visited.contains(neighbor))
                count += getComponentCount(graph, neighbor, visited);
        }

        return count;

    }

    public static int numberOfComponents(Map<Integer, List<Integer>> graph){
        int count = 0;
        Set<Integer> visited = new HashSet<>();

        for(Integer node : graph.keySet()){
            if(!visited.contains(node)){
                count++;
            }else {
                continue;
            }

            Stack<Integer> nodesStack = new Stack<>();
            nodesStack.push(node);

            while (!nodesStack.empty()){
                Integer current = nodesStack.pop();
                visited.add(current);
                for(Integer neighbor : graph.get(current)){
                    if(!visited.contains(neighbor))
                        nodesStack.push(neighbor);
                }
            }
        }


        return count;
    }

    public static void main(String[] args) {
        Integer[][] edges = {
                {1, 2},
                {3, null},
                {4, 6},
                {5, 6},
                {6, 7},
                {6, 8}
        };

        Map<Integer, List<Integer>> graph = getGraphFromEdges(edges);

        System.out.println(numberOfComponents(graph));
        System.out.println(largestComponent(graph));
    }

    private static Map<Integer, List<Integer>> getGraphFromEdges(Integer[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int row = 0; row < edges.length; ++row){
            for(int col = 0; col < edges[row].length; ++col){
                Integer key = edges[row][col];
                if(key == null)
                    continue;

                for(int i = 0; i < edges[row].length; ++i){
                    if(i != col){
                        if(graph.containsKey(key)){
                            graph.get(key).add(edges[row][i]);
                        }else {
                            ArrayList<Integer> list = new ArrayList<>();
                            if(edges[row][i] != null)
                                list.add(edges[row][i]);

                            graph.put(key, list);
                        }
                    }
                }
            }
        }

        return graph;
    }
}
