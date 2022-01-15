package com.alogrithm.tree;

public class MaxPathSum {

    public static int dftRecursive(Node root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return (int)root.value;

        int leftSum = dftRecursive(root.left);
        int rightSum = dftRecursive(root.right);

        return Math.max((int)root.value + leftSum, (int)root.value + rightSum);
    }

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(19);
        Node<Integer> b = new Node<>(1);
        Node<Integer> c = new Node<>(30);
        Node<Integer> d = new Node<>(15);
        Node<Integer> e = new Node<>(-3);
        Node<Integer> f = new Node<>(11);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(dftRecursive(a));

        String name = "Mhretaab";
        System.out.println(name.substring(0, 2));
    }
}
