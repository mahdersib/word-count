package com.us1.assignment.wordcount.service.dao;

import com.us1.assignment.wordcount.model.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordCountDao {
    @Autowired
    TextRepository textRepository;

    public List<Text> findAllTexts(){
        return (List<Text>) textRepository.findAll();
    }
    public void saveText(Text text){
        textRepository.save(text);
    }

    public void deleteAll(){
        textRepository.deleteAll();
    }

    public long count(){
        return textRepository.count();
    }


}
