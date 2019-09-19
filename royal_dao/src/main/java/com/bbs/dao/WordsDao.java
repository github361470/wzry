package com.bbs.dao;

import com.bbs.domain.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsDao {

    @Select("select * from bbs_word_table")
    List<Word> findAllWords();

    @Insert("insert into bbs_word_table (word,status) values(#{word},#{status})")
    void addNewWord(Word word);

    @Update("update bbs_word_table set status=0 where wordId=#{id} ")
    void Word_On(int id);

    @Update("update bbs_word_table set status=1 where wordId=#{id} ")
    void wordsDao(int id);

    @Select("select * from bbs_word_table where word=#{word}")
    Word findByWord(Word word);
}
