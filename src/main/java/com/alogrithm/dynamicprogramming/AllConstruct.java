package com.alogrithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {

    //TODO: Have problem with memoization
    public static List<List<String>> solve(String target, String[] wordBank, Map<String, Object> memo){
        if(memo == null){
            memo = new HashMap<>();
        }

        if(memo.containsKey(target)){
            return (List<List<String>>) memo.get(target);
        }

        if(target.isEmpty()){
            List<String> empty = new ArrayList<>();
            return new ArrayList<>(){{add(empty);}};
        }

        List<List<String>> result = new ArrayList<>();

        for(final String word : wordBank){
            if(target.startsWith(word)){
                final String suffix = target.substring(word.length());
                List<List<String>> suffixWays = solve(suffix, wordBank, memo);

                if(suffixWays != null){
                    for(List<String> list : suffixWays){
                        list.add(0, word);
                    }

                    for(List<String> list : suffixWays){
                        result.add(list);
                    }
                }
            }
        }

        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, null));
        System.out.println(solve("purple", new String[]{"purp", "p", "ur", "le", "purple"}, null));
        System.out.println(solve("ab", new String[]{"cd", "ef"}, null));
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
