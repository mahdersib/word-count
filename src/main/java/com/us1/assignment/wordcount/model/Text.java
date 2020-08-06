package com.us1.assignment.wordcount.model;

import javax.persistence.*;

@Entity
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String textValue;
    private String orderedWordsCount;

    public Text(String textValue,  String orderedWordsCount) {
        this.id = id;
        this.textValue = textValue;
        this.orderedWordsCount = orderedWordsCount;
    }

    public Text() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }


    public String getOrderedWordsCount() {
        return orderedWordsCount;
    }

    public void setOrderedWordsCount(String orderedWordsCount) {
        this.orderedWordsCount = orderedWordsCount;
    }
}
