package com.bbs.domain;
import java.io.Serializable;

/**
 * bbs_word_table
 * @author 
 */
public class Word implements Serializable {
    private Integer wordid;

    /**
     * 敏感词
     */
    private String word;

    /**
     * 是否启用
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Word other = (Word) that;
        return (this.getWordid() == null ? other.getWordid() == null : this.getWordid().equals(other.getWordid()))
            && (this.getWord() == null ? other.getWord() == null : this.getWord().equals(other.getWord()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWordid() == null) ? 0 : getWordid().hashCode());
        result = prime * result + ((getWord() == null) ? 0 : getWord().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wordid=").append(wordid);
        sb.append(", word=").append(word);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}