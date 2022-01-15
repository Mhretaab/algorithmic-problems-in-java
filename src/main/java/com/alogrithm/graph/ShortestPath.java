package com.alogrithm.graph;

import java.util.*;

public class ShortestPath {

    public static int shortestPath(Map<Character , List<Character>> graph, Character src, Character dest){
        Queue<Character> nodes = new LinkedList<>();
        nodes.add(src);
        Map<Character, Integer> count = new HashMap<>(){{put(src, 0);}};
        Set<Character> visited = new HashSet<>();
        visited.add(src);
        while(!nodes.isEmpty()){
            Character current = nodes.poll();
            if(current.equals(dest)){
                return count.get(current);
            }

            for(Character neighbor : graph.get(current)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    nodes.offer(neighbor);
                    count.put(neighbor, count.get(current) + 1);
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] edges = {
                {'w', 'x'},
                {'x', 'y'},
                {'z', 'y'},
                {'z', 'v'},
                {'w', 'v'}
        };

        Map<Character, List<Character>> graph = getGraph(edges);

        System.out.println(graph);

        System.out.println(shortestPath(graph, 'z', 'w'));
    }

    private static Map<Character, List<Character>> getGraph(char[][] edges) {
        Map<Character, List<Character>> graph = new HashMap<>();

        for(int row = 0; row < edges.length; ++row){
            char val1 = edges[row][0];
            char val2 = edges[row][1];

            if(graph.containsKey(val1)){
                graph.get(val1).add(val2);
            }else {
                graph.put(val1, new ArrayList<>(){{add(val2);}});
            }

            if(graph.containsKey(val2)){
                graph.get(val2).add(val1);
            }else {
                graph.put(val2, new ArrayList<>(){{add(val1);}});
            }
        }

        return graph;
    }
}
