package com.alogrithm.graph;

import java.util.*;

public class Basics {

    public static void depthFirstTraversal(Map<Character, List<Character>> graph, Character firstNode){
        Stack<Character> nodes = new Stack<>();
        nodes.push(firstNode);

        while (!nodes.empty()){
            Character current = nodes.pop();
            System.out.print(current + " ");
            List<Character> adjacentNodes = graph.get(current);
            for(char neighborNode : adjacentNodes){
                nodes.push(neighborNode);
            }
        }
    }

    public static void depthFirstRecursive(Map<Character, List<Character>> graph, Character firstNode){
        System.out.print(firstNode + " ");
        for(Character neighbor : graph.get(firstNode)){
            depthFirstRecursive(graph, neighbor);
        }
    }

    public static void breadthFirstTraversal(Map<Character, List<Character>> graph, Character firstNode){
        Queue<Character> nodes = new LinkedList<>();
        nodes.offer(firstNode);

        while (!nodes.isEmpty()){
            Character current = nodes.poll();
            System.out.print(current + " ");
            List<Character> neighbors = graph.get(current);
            for(Character neighbor : neighbors){
                nodes.offer(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', new ArrayList<>(){{add('b'); add('c');}});
        graph.put('b', new ArrayList<>(){{add('d');}});
        graph.put('c', new ArrayList<>(){{add('e');}});
        graph.put('d', new ArrayList<>(){{add('f');}});
        graph.put('e', new ArrayList<>());
        graph.put('f', new ArrayList<>());

        depthFirstTraversal(graph, 'a');
        System.out.println();
        depthFirstRecursive(graph, 'a');
        System.out.println();
        breadthFirstTraversal(graph, 'a');
    }
}
