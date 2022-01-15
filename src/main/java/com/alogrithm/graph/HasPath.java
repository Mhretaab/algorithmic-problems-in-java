package com.alogrithm.graph;

import java.util.*;

public class HasPath {

    public static boolean depthFirstSolution(Map<Character, List<Character>> graph, Character src, Character dest){
        Stack<Character> nodes = new Stack<>();
        nodes.push(src);
        boolean hasPath = false;

        while (!nodes.empty()){
            Character current = nodes.pop();
            if(current.equals(dest)){
                hasPath = true;
                break;
            }
            List<Character> neighbors = graph.get(current);
            for(Character neighbor : neighbors){
                nodes.push(neighbor);
            }
        }

        return hasPath;
    }

    public static boolean dftRecursive(Map<Character, List<Character>> graph, Character src, Character dest){
        if(src.equals(dest)) return true;

        for(Character neighbor : graph.get(src)){
            if(dftRecursive(graph, neighbor, dest)){
                return true;
            }
        }

        return false;
    }

    public static boolean breadthFirstSolution(Map<Character, List<Character>> graph, Character src, Character dest){
        Queue<Character> nodes = new LinkedList<>();
        nodes.offer(src);
        boolean hasPath = false;

        while (!nodes.isEmpty()){
            Character current = nodes.poll();
            if(current.equals(dest)){
                hasPath = true;
                break;
            }

            for(Character neighbor : graph.get(current)){
                nodes.add(neighbor);
            }
        }

        return hasPath;
    }

    public static boolean undirectedPathDepthFirst(char[][] edges, char src,char dest){
        Map<Character, List<Character>> graph = getGraphFromEdges(edges);
        Stack<Character> nodes = new Stack<>();
        nodes.push(src);
        Set<Character> visited = new HashSet<>();

        while (!nodes.empty()){
            Character current = nodes.pop();
            if(current.equals(dest)){
                return true;
            }
            visited.add(current);
            for(Character neighbor : graph.get(current)){
                if(!visited.contains(neighbor)){
                    nodes.push(neighbor);
                }
            }
        }

        return false;
    }

    private static Map<Character, List<Character>> getGraphFromEdges(char[][] edges) {
        Map<Character, List<Character>> graph = new HashMap<>();

        for(int row = 0; row < edges.length; ++row){
            for(int col = 0; col < edges[row].length; ++col){
                Character key = edges[row][col];
                for(int i = 0; i < edges[row].length; ++i){
                    if(i != col){
                        if(graph.containsKey(key)){
                            graph.get(key).add(edges[row][i]);
                        }else {
                            ArrayList<Character> list = new ArrayList<>();
                            list.add(edges[row][i]);
                            graph.put(key, list);
                        }
                    }
                }
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('f', new ArrayList<>(){{add('g'); add('i');}});
        graph.put('g', new ArrayList<>(){{add('h');}});
        graph.put('h', new ArrayList<>());
        graph.put('i', new ArrayList<>(){{add('g');add('k');}});
        graph.put('j', new ArrayList<>(){{add('i');}});
        graph.put('k', new ArrayList<>());

        System.out.println(depthFirstSolution(graph, 'f', 'k'));
        System.out.println(depthFirstSolution(graph, 'j', 'f'));

        System.out.println(dftRecursive(graph, 'f', 'k'));
        System.out.println(dftRecursive(graph, 'j', 'f'));

        System.out.println(breadthFirstSolution(graph, 'f', 'k'));
        System.out.println(breadthFirstSolution(graph, 'j', 'f'));

        //Undirected Path
        char[][] edges = {
                {'i', 'j'},
                {'k', 'i'},
                {'m', 'k'},
                {'k', 'l'},
                {'o', 'n'}
        };

        System.out.println("========================================");

        System.out.println(undirectedPathDepthFirst(edges, 'i', 'l'));
        System.out.println(undirectedPathDepthFirst(edges, 'i', 'n'));
    }
}
