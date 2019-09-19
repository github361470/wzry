package com.bbs.service.impl;

import com.bbs.dao.WordsDao;
import com.bbs.domain.Word;
import com.bbs.service.WordsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WordsServiceImpl implements WordsService {

    @Autowired
    private WordsDao wordsDao;

    @Override
    public List<Word> findAllWords(int page,int size) {
        PageHelper.startPage(page,size);
        return wordsDao.findAllWords();
    }

    @Override
    public void addNewWord(Word word) {
        if(word.getWord().trim().length()>0){
            wordsDao.addNewWord(word);
        }
    }

    @Override
    public void Word_On(int id) {
        wordsDao.Word_On(id);
    }

    @Override
    public void Word_Off(int id) {
        wordsDao.wordsDao(id);
    }

    @Override
    public boolean findByName(Word word) {
        Word w = wordsDao.findByWord(word);
        if (w==null){
            return false;
        }
        return true;
    }
}
