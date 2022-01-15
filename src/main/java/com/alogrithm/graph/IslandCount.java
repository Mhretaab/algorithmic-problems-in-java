package com.alogrithm.graph;

import java.util.HashSet;
import java.util.Set;

public class IslandCount {
    public static int islandCount(char[][] graph) {
        int count = 0;

        Set<String> visited = new HashSet<>();

        for (int row = 0; row < graph.length; ++row) {
            for (int col = 0; col < graph[row].length; ++col) {
                if (explore(graph, row, col, visited) == true) {
                    ++count;
                }
            }
        }

        return count;
    }

    private static boolean explore(char[][] graph, int row, int col, Set<String> visited) {
        boolean rowInbound = 0 <= row && row < graph.length;
        if (!rowInbound) return false;

        boolean colInbound = 0 <= col && col < graph[row].length;
        if (!colInbound) return false;

        if (graph[row][col] == 'W') return false;

        String key = row + "," + col;
        if (visited.contains(key)) return false;

        visited.add(key);

        explore(graph, row - 1, col, visited);
        explore(graph, row + 1, col, visited);
        explore(graph, row, col - 1, visited);
        explore(graph, row, col + 1, visited);

        return true;
    }

    public static void main(String[] args) {
        char[][] graph = {
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'L', 'W'},
                {'W', 'W', 'L', 'L', 'W'},
                {'L', 'W', 'W', 'L', 'L'},
                {'L', 'L', 'W', 'W', 'W'}
        };


        System.out.println(islandCount(graph));
    }
}
