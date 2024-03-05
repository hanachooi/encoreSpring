package com.example.encoreSpring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
public class BoardResponse {

    private String title;
    private String content;
    private String writer;
    private boolean noticeYn;
    private boolean secretYn;
}
