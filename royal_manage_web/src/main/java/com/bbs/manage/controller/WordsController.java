package com.bbs.manage.controller;

import com.bbs.domain.Word;
import com.bbs.service.WordsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 添加新的敏感词汇
     * @param word
     * @return
     */
    @RequestMapping("/addNewWord.do")
    public String addNewWord(Word word) {
        wordsService.addNewWord(word);
        return "forward:findByPage.do";
    }

    /**
     * 开启敏感词汇
     * @param id
     * @param page
     * @return
     */
    @RequestMapping("/Word_On.do")
    @ResponseBody
    public boolean Word_On(int id, int page) {
        try {
            wordsService.Word_On(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
        // return "forward:findByPage.do?page=" + page;
    }

    /**
     * 关闭敏感词汇
     * @param id
     * @param page
     * @return
     */
    @RequestMapping("/Word_Off.do")
    @ResponseBody
    public boolean Word_Off(int id, int page) {
        try {
            wordsService.Word_Off(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
        //return "forward:findByPage.do?page=" + page;
    }
    @RequestMapping("/findRecur.do")
    @ResponseBody
    public boolean findRecur(Word word){
        return wordsService.findByName(word);
    }
}
