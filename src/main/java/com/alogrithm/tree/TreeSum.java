package com.alogrithm.tree;

public class TreeSum {

    public static int dftRecursive(Node root){
        if(root == null) return 0;
        return (int) root.value + dftRecursive(root.left) + dftRecursive(root.right);
    }

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(19);
        Node<Integer> b = new Node<>(1);
        Node<Integer> c = new Node<>(30);
        Node<Integer> d = new Node<>(15);
        Node<Integer> e = new Node<>(3);
        Node<Integer> f = new Node<>(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(dftRecursive(a));
    }
}
