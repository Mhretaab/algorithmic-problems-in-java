package com.alogrithm.backtracking;

public class HamiltonianCycle {
    private final int numberOfVertices;
    private final int[] hamiltonianPath;
    private final int[][] adjacencyMatrix;

    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.hamiltonianPath = new int[adjacencyMatrix.length];
        this.numberOfVertices = adjacencyMatrix.length;
    }

    public void solve() {
        this.hamiltonianPath[0] = 0;

        if (findFeasibleSolution(1)) {
            showHamiltonianPath();
        } else {
            System.out.println("No feasible solution found.");
        }
    }

    private void showHamiltonianPath() {
        System.out.println("Hamiltonian Path: ");
        for (int i = 0; i < hamiltonianPath.length; ++i)
            System.out.print(hamiltonianPath[i] + " ");

        System.out.print(hamiltonianPath[0]);
    }

    private boolean findFeasibleSolution(int position) {
        if (position == numberOfVertices) {
            if (adjacencyMatrix[hamiltonianPath[position - 1]][0] == 1) {
                return true;
            } else {
                return false;
            }
        }

        for (int vertexIndex = 1; vertexIndex < numberOfVertices; ++vertexIndex) {
            if (isFeasible(vertexIndex, position)) {
                hamiltonianPath[position] = vertexIndex;
                if (findFeasibleSolution(position + 1)) {
                    return true;
                }

                //BACKTRACKING!!
            }
        }

        return false;
    }

    private boolean isFeasible(int vertexIndex, int actualPostion) {
        //check for connection
        if (adjacencyMatrix[hamiltonianPath[actualPostion - 1]][vertexIndex] == 0) {
            return false;
        }

        //check if visited
        for (int i = 0; i < actualPostion; ++i) {
            if (hamiltonianPath[i] == vertexIndex) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };

        new HamiltonianCycle(adjacencyMatrix).solve();

        int[][] adjacencyMatrix2 = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        };
        new HamiltonianCycle(adjacencyMatrix2).solve();
    }
}
