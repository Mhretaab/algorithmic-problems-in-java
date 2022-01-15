package com.alogrithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Trie {
    final Node root;

    public Trie(){
        root = new Node('\0');
    }

    public void insert(String word){
        Node current = root;
        for(int i = 0; i < word.length(); ++i){
            if(current.children[word.charAt(i) - 'a'] != null){
                current = current.children[word.charAt(i) - 'a'];
                continue;
            }
            Node child = new Node(word.charAt(i));
            current.children[word.charAt(i) - 'a'] = child;
            current = child;
        }
        current.isWord = true;
    }

    public void insert(List<String> repositories){
        for(String word : repositories){
            insert(word);
        }
    }

    public List<String> query(String prefix){
        Node current = root;
        for(int i = 0; i < prefix.length(); ++i){
            current = current.next(prefix.charAt(i));
        }

        List<Character> chars = new ArrayList<>();
        List<String> suffixes = new ArrayList<>();
        query(current, chars, suffixes);

        List<String> result = suffixes.stream().map(suffix -> prefix + suffix).collect(Collectors.toList());

        System.out.println(result);
        return result;
    }

    public void query(Node subtreeParent, List<Character> chars, List<String> suffixes){
        if(subtreeParent == null)
            return;

        if(suffixes.size() == 2)
            return;

        for(int i = 0; i < subtreeParent.children.length; ++i){
            Node child = subtreeParent.children[i];
            if(child == null) continue;

            char ch = (char) ('a' + i);
            chars.add(ch);

            if(child.isWord){
                StringBuffer sb = new StringBuffer();
                for(char c : chars)
                    sb.append(c);

                suffixes.add(sb.toString());

                if(!hasChildren(child))
                    chars.clear();
            }
            query(child, chars, suffixes);
        }
    }

    private boolean hasChildren(Node child) {

        for(Node node : child.children){
            if(node != null)
                return true;
        }

        return false;
    }

    class Node {
        char ch;
        boolean isWord;
        Node[] children = new Node[26];

        public Node(char ch){
            this.ch = ch;
            Arrays.fill(children, null);
        }

        public Node next(char ch){
            return children[ch - 'a'];
        }
    }

    public static void main(String[] args) {
        List<String> repositories = new ArrayList<>();
        repositories.add("mobile");
        repositories.add("money");
        repositories.add("mouse");
        repositories.add("mousepad");

        Trie trie = new Trie();

        trie.insert(repositories);

        trie.query("mob");
    }
}
