package com.example.encoreSpring.domain;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.Builder;

/*
 Builder Pattern
 StudentRequest
 -- String name, address, stuId, common ....
 -- StudentRequest(String name, String address, String stuId ,... ) = new StudentRequest(name, adress, .. ){};
*/

//@Builder        // 빌더 패턴일 때는, 빌더로 객체를 관리(getter, setter, 생성) 하므로,다른 어노테이션을 쓸 필요가 없다.
@Getter
@Setter
@ToString
@NoArgsConstructor
//@NoArgsConstructor  // 빌더 패턴이 없을 때, 만드는 생성자
public class BoardRequest {

    // 값을 넘기는 건 보통, Request에 담아준다.

    private Integer idx;
    private String title;
    private String content;
    private String writer;
    private boolean noticeYN;
    private boolean secretYN;


}
