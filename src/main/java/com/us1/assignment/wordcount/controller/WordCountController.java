package com.us1.assignment.wordcount.controller;

import com.us1.assignment.wordcount.service.dao.WordCountDao;
import com.us1.assignment.wordcount.service.impl.WordCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WordCountController implements ErrorController {
    @Autowired
    WordCountDao wordCountDao;

    @Autowired
    WordCountService wordCountService;

    @GetMapping("/wordcount")
    public String wordcount(){
        return "index";
    }
    @RequestMapping(value="/wordcount", params = "orderbyFreq", method = RequestMethod.POST)
    public String orderByFreq(@RequestParam String textVal, Model model){
        if(!textVal.equals("")) {
            model.addAttribute("countedWords",wordCountService.countWords(textVal,"Freq"));
        }
        return "index";
    }

    @RequestMapping(value="/wordcount", params = "orderbyAlphabet", method = RequestMethod.POST)
    public String orderByAlphabet(@RequestParam String textVal, Model model){
        if(!textVal.equals("")){
            model.addAttribute("countedWords",wordCountService.countWords(textVal,"Alph"));
        }
        return "index";
    }

    @RequestMapping(value="/wordcount", params = "clean", method = RequestMethod.POST)
    public String deleteAll(){
        wordCountDao.deleteAll();
        return "index";
    }

    @RequestMapping(value="/wordcount", params = "list", method = RequestMethod.GET)
    public String listAll(Model model){
        if(wordCountDao.count()!=0){
            model.addAttribute("insertedTexts", wordCountDao.findAllTexts());
        }else{
            model.addAttribute("message", "Database is empty. Go back and insert texts.");
        }
        return "list-all-texts";
    }

    @Override
    @RequestMapping("/error")
    @ResponseBody
    public String getErrorPath() {
        return "No Mapping Found";
    }
}
