package com.alogrithm.string;

public class NumberOfSentences {

    public static int countSentences(String paragraph){
        int length = paragraph.split("[!?.(? )]").length;
        return length;
    }

    public static void main(String[] args) {
        String sentence = "do you love cake? go and bring from it!";
        System.out.println(countSentences(sentence));
    }
}
