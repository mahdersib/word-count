package com.us1.assignment.wordcount;

import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static org.junit.Assert.assertEquals;

public class WordCountAppTest {
    @InjectMocks
    private WordCountApp wordCountApp;

    @Test
    public void printInFrequencyOrder(){
        HashMap<String, Integer> wordMap = new HashMap<>();
        wordMap.put("abe",2);
        wordMap.put("beb",5);
        wordMap.put("ced",3);
        HashMap<String,Integer> expectedWordCount = wordMap.entrySet().stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors
                        .toMap(e->e.getKey(), e->e.getValue(),(e1, e2)->e1, LinkedHashMap::new));
        HashMap<String, Integer> actualWordCount = wordCountApp.printInFrequencyOrder(wordMap);
        List<String> actualFreqOrderList = new ArrayList<>();
        List<String> expectedFreqOrderList = new ArrayList<>();
        expectedWordCount.forEach((key,value) ->
                expectedFreqOrderList.add(key));
        actualWordCount.forEach((key,value) ->
                actualFreqOrderList.add(key));
        assertEquals(actualWordCount,expectedWordCount);
        assertEquals(actualFreqOrderList,expectedFreqOrderList);
    }
    @Test
    public void printInAlphabeticalOrder(){
        HashMap<String, Integer> wordMap = new HashMap<>();
        wordMap.put("ced",12);
        wordMap.put("beb",15);
        wordMap.put("abe",13);
        HashMap<String,Integer> expectedWordCount = wordMap.entrySet().stream()
                .sorted(comparingByKey())
                .collect(Collectors
                        .toMap(e->e.getKey(), e->e.getValue(),(e1, e2)->e1, LinkedHashMap::new));
        HashMap<String, Integer> actualWordCount = wordCountApp.printInAlphabeticalOrder(wordMap);
        List<String> actualFreqOrderList = new ArrayList<>();
        List<String> expectedFreqOrderList = new ArrayList<>();
        expectedWordCount.forEach((key,value) ->
                expectedFreqOrderList.add(key));
        actualWordCount.forEach((key,value) ->
                actualFreqOrderList.add(key));
        assertEquals(actualWordCount,expectedWordCount);
        assertEquals(actualFreqOrderList,expectedFreqOrderList);
    }
}
