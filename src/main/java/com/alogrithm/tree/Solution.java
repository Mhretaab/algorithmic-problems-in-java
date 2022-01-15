package com.alogrithm.tree;

import java.util.ArrayList;
import java.util.List;



class Result {

    static class Node{
        char c;
        Node[] children;
        boolean isWord;

        public Node(char c){
            this.c = c;
            children = new Node[26];
        }

        public Node buildTrie(String word){
            word = word.toLowerCase();

            for(int i = 0; i < word.length(); ++i){
                char ch = word.charAt(i);
                Node child = new Node(ch);
                if(i == word.length()-1){
                    child.isWord = true;
                }
            }

            return null;
        }

        public void buildTrie(List<String> repository){
            Node tracking = this;
            for(String word : repository){
                tracking = buildTrie(word);
            }
        }

        public  List<String> suggest(String query){
            return null;
        }

        public Node addChild(char ch, boolean isWord){
            Node child = new Node(ch);
            child.isWord = isWord;
            this.children[ch - 97] = child;

            return child;
        }

    }

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here

        Node root = new Node('\0');
        root.buildTrie(repository);

        List<List<String>> suggestions = new ArrayList<>();

        for(int i = 2; i <= customerQuery.length(); ++i){
            String query = customerQuery.substring(0, i);
            suggestions.add(root.suggest(query));
        }

        return suggestions;
    }

}

public class Solution {
    public static void main(String[] args){

    }
}
