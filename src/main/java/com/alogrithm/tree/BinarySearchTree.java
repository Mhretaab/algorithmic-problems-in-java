package com.alogrithm.tree;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    public void insert(int value){
        Node node = new Node(value);
        if(root == null){
            root = node;
            return;
        }

        Node current = root;
        Node prvCurrent = root;

        while(current != null){
            prvCurrent = current;

            if(value < current.value){
                current = current.left;
            }else {
                current = current.right;
            }
        }

        if(value < prvCurrent.value){
            prvCurrent.left = node;
        }else {
            prvCurrent.right = node;
        }
    }

    public void printValues(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            Node current = stack.pop();
            System.out.print(current + " ");

            if(current.right != null) stack.push(current.right);
            if(current.left != null) stack.push(current.left);
        }
    }

    public boolean search(int value){
        return search(root, value);
    }

    private boolean search(Node root, int value) {
        if(root == null) return false;
        if(root.value == value) return true;

        if(value < root.value) search(root.left, value);
        else search(root.right, value);

        return false;
    }

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree(19);
        binarySearchTree.insert(1);
        binarySearchTree.insert(30);
        binarySearchTree.insert(15);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);

        binarySearchTree.printValues();

        Queue<Integer> priority = new PriorityQueue<>();
        priority.add(23);
        priority.add(3);
        priority.add(77);
        priority.add(23);
        priority.add(34);

        System.out.println();
        while(!priority.isEmpty()){
            Integer current = priority.poll();
            System.out.print(current + " ");
        }

    }
}
