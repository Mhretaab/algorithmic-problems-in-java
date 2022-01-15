package com.alogrithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    public static boolean solve(String target, String[] wordsBank, Map<String, Boolean> memo){
        if(memo == null)
            memo = new HashMap<>();

        if(memo.containsKey(target))
            return memo.get(target);

        if(target.isEmpty())
            return true;

        for(String word : wordsBank){
            if(target.startsWith(word)){
                String suffix = target.substring(word.length());
                if(solve(suffix, wordsBank, memo) == true){
                    memo.put(target, true);
                    return memo.get(target);
                }
            }
        }

        memo.put(target, false);
        return memo.get(target);
    }

    public static void main(String[] args) {
        System.out.println(solve("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, null));
        System.out.println(solve("abcdf", new String[]{"ab", "abc", "cd", "def", "abcd"}, null));
        System.out.println(solve("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee"
        }, null));
    }
}
