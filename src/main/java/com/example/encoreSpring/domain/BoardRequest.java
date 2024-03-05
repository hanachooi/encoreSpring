package com.example.encoreSpring.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardRequest {
    private String title;
    private String content;
    private String writer;
    private boolean noticeYN;
    private boolean secretYN;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public boolean getNoticeYN() {
        return noticeYN;
    }

    public void setNoticeYN(boolean noticeYN) {
        this.noticeYN = noticeYN;
    }

    public boolean getSecretYN() {
        return secretYN;
    }

    public void setSecretYN(boolean secretYN) {
        this.secretYN = secretYN;
    }
}
