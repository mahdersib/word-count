package com.us1.assignment.wordcount;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static java.util.Map.Entry.*;

public class WordCountApp {
    public static void main(String args[]){

        String text = "This is a test input for a program:22 $$ history, one two#two or, three*three*three four!four!four!four story.";
        String patternString = "[\\s.:$,#*!]+";

        Pattern pattern = Pattern.compile(patternString);
        String[] wordsArray = pattern.split(text);
        Map<String,Integer> wordMap;

        wordMap = Arrays.stream(wordsArray).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        printInFrequencyOrder(wordMap).forEach((key,value)-> System.out.println(key+ " ("+value+")"));
        printInAlphabeticalOrder(wordMap).forEach((key,value)-> System.out.println(key+ " ("+value+")"));
    }

    public static HashMap<String,Integer> printInFrequencyOrder(Map<String,Integer> wordMap){
        System.out.println("Frequency list (with counts in parentheses)");
        HashMap<String,Integer> frequencyOrder = wordMap.entrySet().stream().sorted(comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue(),(e1, e2)->e1, LinkedHashMap::new));
        return frequencyOrder;
    }

    public static HashMap<String,Integer> printInAlphabeticalOrder(Map<String,Integer> wordMap){
        System.out.println("Alphabetical list (with counts in parentheses)");
        HashMap<String,Integer> alphabeticalOrder =wordMap.entrySet().stream().sorted(comparingByKey()).
                collect(Collectors.toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e2, LinkedHashMap::new));
        return alphabeticalOrder;
    }
}
