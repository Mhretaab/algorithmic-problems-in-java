package com.alogrithm.backtracking;

public class ColoringProblem {
    private int numberOfVertices;
    private int numberOfColors;
    private int[] colors;
    private int[][] adjacencyMatrix;

    public ColoringProblem(int numberOfColors, int[][] adjacencyMatrix) {
        this.numberOfColors = numberOfColors;
        this.adjacencyMatrix = adjacencyMatrix;
        this.numberOfVertices = adjacencyMatrix.length;
        this.colors = new int[this.numberOfVertices];
    }

    public void solve() {
        if (solveProblem(0)) {
            showResult();
        } else {
            System.out.println("No feasible solution...");
        }
    }

    private boolean solveProblem(int nodeIndex) {
        if (nodeIndex == numberOfVertices) {
            return true;
        }

        for (int colorIndex = 1; colorIndex <= numberOfColors; ++colorIndex) {
            if (isValidColor(colorIndex, nodeIndex)) {
                this.colors[nodeIndex] = colorIndex;

                if (solveProblem(nodeIndex + 1)) {
                    return true;
                }

                //BACKTRACK !!!
            }
        }

        return false;
    }

    private boolean isValidColor(int colorIndex, int nodeIndex) {
        for (int i = 0; i < numberOfVertices; ++i) {
            if (adjacencyMatrix[nodeIndex][i] == 1 && colors[i] == colorIndex) {
                return false;
            }
        }

        return true;
    }

    private void showResult() {
        for (int i = 1; i <= numberOfVertices; ++i) {
            System.out.println("Node " + i + " has color: " + colors[i - 1]);
        }
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0}
        };

        new ColoringProblem(2, adjacencyMatrix).solve();
        new ColoringProblem(3, adjacencyMatrix).solve();
        new ColoringProblem(4, adjacencyMatrix).solve();
    }
}
