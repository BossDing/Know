package com.jude.know.model.bean;

/**
 * Created by zhuchenxi on 15/6/8.
 */
public class AnswerResult {
    int totalCount;
    int totalPage;
    Answer[] answers;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }
}
