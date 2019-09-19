package com.bbs.domain;
import java.io.Serializable;

/**
 * bbs_word_table
 * @author
 */
public class Word implements Serializable {
    private Integer wordId;

    /**
     * 敏感词
     */
    private String word;

    /**
     * 是否启用
     */
    private Integer status;

    private String statusStr;

    public String getStatusStr() {
        if(status==0){
            statusStr="禁用";
        }else if (status==1){
            statusStr="使用中";
        }

        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    private static final long serialVersionUID = 1L;

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
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
        return (this.getWordId() == null ? other.getWordId() == null : this.getWordId().equals(other.getWordId()))
                && (this.getWord() == null ? other.getWord() == null : this.getWord().equals(other.getWord()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWordId() == null) ? 0 : getWordId().hashCode());
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
        sb.append(", wordId=").append(wordId);
        sb.append(", word=").append(word);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}