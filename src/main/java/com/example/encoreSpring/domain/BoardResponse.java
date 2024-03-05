package com.example.encoreSpring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDateTime;

@Getter @Setter @ToString @NoArgsConstructor
public class BoardResponse {

    private Integer idx;
    private String title;
    private String content;
    private String writer;
    private Integer viewCnt;
    private boolean noticeYn;
    private boolean secretYn;
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;

}

