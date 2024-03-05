package com.example.encoreSpring;

import com.example.encoreSpring.domain.BoardRequest;
import com.example.encoreSpring.domain.BoardResponse;
import com.example.encoreSpring.mapper.BoardMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisOrmTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void ormSave(){
        System.out.println("debug >>>>> " + boardMapper);
        BoardRequest request = new BoardRequest();
        request.setTitle("orm수업");
        request.setContent("mybatis mappng");
        request.setWriter("encore");
        request.setNoticeYN(true);
        request.setSecretYN(true);
        boardMapper.save(request);
        System.out.println("deug >>> save success");
    }

    @Test
    public void ormFind() throws JsonProcessingException {
        System.out.println("debug finder >>>>>>>>>>>>>>>> ");
        BoardRequest request = new BoardRequest();
        request.setIdx(1);
        // 함수 실행은 Mapper를 통해서, 일어난다.
        BoardResponse response = boardMapper.findByIdx(request);
        System.out.println("debug find result response >>>");
        String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(response);
        System.out.println(response);
        System.out.println("debug find json result response (key : value)>>>");
        System.out.println(boardJson);
    }

    @Test
    public void ormUpdate() {
        System.out.println("debug update >>>>>> ");
        BoardRequest request = new BoardRequest();
        request.setIdx(1);
        request.setTitle("ddd");
        request.setContent("ddd");
        request.setWriter("ddd");
        boardMapper.updateById(request);
    }

    @Test
    public void count(){
        System.out.println("debug count >>>>>");
        BoardRequest request = new BoardRequest();
        System.out.println(boardMapper.count());
    }

    @Test
    public void delete(){
        // 만약에, delete 날짜를 관리한다면, update 구문으로 활용해야 함.

        System.out.println("debug delete >.>>> ");
        BoardRequest request = new BoardRequest();
        // 요청이 어떤 요청인지.
        request.setIdx(1);
        // 요청에 따른 MyBatis(Mapper) 실행
        boardMapper.deleteByIdx(request);
    }

    @Test
    public void findAll(){
        System.out.println("debug findAll >>>>>");
        BoardRequest request = new BoardRequest();
        List<BoardResponse> list =  boardMapper.findAll();
        for(BoardResponse b : list){
            System.out.println(b.toString());
        }
    }

}
