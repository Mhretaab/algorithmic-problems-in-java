package com.alogrithm.tree;

import java.util.*;

class Node<T> {
    T value;
    Node left;
    Node right;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}

public class Basics {

    public static List<Node> depthFirstTraversal(Node root) {
        if (root == null)
            return null;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        List<Node> nodes = new ArrayList<>();

        while (!stack.empty()) {
            Node current = stack.pop();
            System.out.print(current + " ");
            nodes.add(current);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }

        return nodes;
    }

    public static List<Node> dftRecursive(Node root) {
        if (root == null) return null;

        List<Node> nodes = new ArrayList<>();
        nodes.add(root);

        List<Node> left = dftRecursive(root.left);
        if (left != null) nodes.addAll(left);
        List<Node> right = dftRecursive(root.right);
        if (right != null) nodes.addAll(right);

        return nodes;
    }

    public static List<Node> breadthFirstTraversal(Node root) {
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Node> nodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current + " ");
            nodes.add(current);
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }

        return nodes;
    }

    public static void breadthFirstTraversalLevelPrint(Node root) {
        if (root == null) return;

        Queue<NodeWithLevel> queue = new LinkedList<>();
        queue.offer(new NodeWithLevel(root, 0));
        Queue<NodeWithLevel> printQueue = new LinkedList<>();

        while (!queue.isEmpty()) {
            NodeWithLevel current = queue.poll();

            printQueue.offer(current);

            if (current.node.left != null) {
                queue.offer(new NodeWithLevel(current.node.left, current.level + 1));
            }
            if (current.node.right != null) {
                queue.offer(new NodeWithLevel(current.node.right, current.level + 1));
            }
        }

        int level = 0;
        while(!printQueue.isEmpty()){
            NodeWithLevel node = printQueue.poll();
            if(node.level != level){
                System.out.println();
                level = node.level;
            }

            System.out.print(node.node + " ");
        }
    }

    static class NodeWithLevel{
        Node node;
        int level;

        public NodeWithLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }

        @Override
        public String toString() {
            return node + " " + level;
        }
    }

    public static void main(String[] args) {
        Node<Character> a = new Node<>('a');
        Node<Character> b = new Node<>('b');
        Node<Character> c = new Node<>('c');
        Node<Character> d = new Node<>('d');
        Node<Character> e = new Node<>('e');
        Node<Character> f = new Node<>('f');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        depthFirstTraversal(a);
        System.out.println();
        System.out.println(dftRecursive(a));
        breadthFirstTraversal(a);

        System.out.println("=======================================");

        breadthFirstTraversalLevelPrint(a);
    }
}
