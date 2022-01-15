package com.alogrithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeIncludes {

    public static boolean BFT(Node root, Object target){
        if(root == null) return  false;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.value.equals(target)){
                return true;
            }

            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }

        return false;
    }

    public static boolean dftRecursive(Node root, Object target){
        if(root == null) return false;
        if(root.value.equals(target)) return true;

        boolean found = false;

        found = found || dftRecursive(root.left, target);
        found = found || dftRecursive(root.right, target);

        return found;
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

        System.out.println(BFT(a, 'e'));
        System.out.println(BFT(a, 'j'));

        System.out.println("===================");

        System.out.println(dftRecursive(a, 'e'));
        System.out.println(dftRecursive(a, 'j'));
        System.out.println(dftRecursive(a, 'm'));
        System.out.println(dftRecursive(a, 'f'));
    }
}
