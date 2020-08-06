package com.us1.assignment.wordcount.service.impl;

import com.us1.assignment.wordcount.model.Text;
import com.us1.assignment.wordcount.service.dao.WordCountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;


@Service
public class WordCountService {
    @Autowired
    WordCountDao wordCountDao;

    public Text countWords(String textValue, String orderType){
        String orderedWordsCount = constructStringToBeDisplayed(textValue,orderType);
        Text text = new Text();
        text.setTextValue(textValue);
        text.setOrderedWordsCount(orderedWordsCount);
        wordCountDao.saveText(text);
        return text;
    }

    public String constructStringToBeDisplayed(String textValue, String orderType){
        StringBuilder orderedWordsCount = new StringBuilder();
        String patternString = "[\\s.:$,#*!]+";
        Pattern pattern = Pattern.compile(patternString);
        String[] wordsArray = pattern.split(textValue);
        Map<String,Integer> wordMap = Arrays.stream(wordsArray).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        if(orderType.equals("Freq")){
            printInFrequencyOrder(wordMap).forEach((key,value)->
                    orderedWordsCount.append("<br/>").append(key).append(" (").append(value).append(")"));

        }else if(orderType.equals("Alph")){
            printInAlphabeticalOrder(wordMap).forEach((key,value)->
                    orderedWordsCount.append("<br/>").append(key).append(" (").append(value).append(")"));

        }
               return orderedWordsCount.toString();
    }
    public HashMap<String,Integer> printInFrequencyOrder(Map<String,Integer> wordMap){
        HashMap<String,Integer> frequencyOrder = wordMap.entrySet().stream().sorted(comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue(),(e1, e2)->e1, LinkedHashMap::new));

        return frequencyOrder;
    }
    public static HashMap<String,Integer> printInAlphabeticalOrder(Map<String,Integer> wordMap){
        HashMap<String,Integer> alphabeticalOrder =wordMap.entrySet().stream().sorted(comparingByKey()).
                collect(Collectors.toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e2, LinkedHashMap::new));
        return alphabeticalOrder;
    }
}
