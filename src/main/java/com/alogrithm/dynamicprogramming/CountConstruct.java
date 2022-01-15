package com.alogrithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {
    public static int solve(String target, String[] wordBank, Map<String, Integer> memo){
        if(memo == null)
            memo = new HashMap<>();

        if(memo.containsKey(target))
            return memo.get(target);

        if(target.isEmpty())
            return 1;

        int totalCount = 0;

        for(String word : wordBank){
            if(target.startsWith(word)){
                String suffix = target.substring(word.length());
                int count = solve(suffix, wordBank, memo);
                totalCount += count;
            }
        }

        memo.put(target, totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(solve("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, null));
        System.out.println(solve("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, null));
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
