package com.bbs.manage.controller;

import com.bbs.domain.Word;
import com.bbs.service.WordsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/word")
public class WordsController {

    @Autowired
    private WordsService wordsService;

    @RequestMapping("/findByPage.do")
    public String findAllWords(Model model,
                               @RequestParam(name = "page", defaultValue = "1") int page,
                               @RequestParam(name = "size", defaultValue = "5") int size) {
        List<Word> wordList = wordsService.findAllWords(page, size);
        PageInfo pageInfo = new PageInfo(wordList);
        model.addAttribute("wordsPage", pageInfo);
        return "WordPage";
    }

    @RequestMapping("/addNewWord.do")
    public String addNewWord(Word word) {
        wordsService.addNewWord(word);
        return "forward:findByPage.do";
    }

    @RequestMapping("/Word_On.do")
    public String Word_On(int id, int page) {
        wordsService.Word_On(id);
        return "forward:findByPage.do?page=" + page;
    }

    @RequestMapping("/Word_Off.do")
    public String Word_Off(int id, int page) {
        wordsService.Word_Off(id);
        return "forward:findByPage.do?page=" + page;
    }
}
