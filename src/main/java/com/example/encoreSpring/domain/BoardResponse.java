package com.example.encoreSpring.domain;

import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Getter @Setter @ToString //@Builder
@NoArgsConstructor
public class BoardResponse {

    private Integer idx;
    private String title;
    private String content;
    private String writer;
    private Integer viewCnt;
    private boolean noticeYn;
    private boolean secretYn;
    private boolean deleteYn;
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;
}

