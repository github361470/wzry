package com.bbs.service;

import com.bbs.domain.Word;

import java.util.List;

public interface WordsService {

    List<Word> findAllWords(int page, int size);

    void addNewWord(Word word);

    void Word_On(int id);

    void Word_Off(int id);

    boolean findByName(Word word);
}
