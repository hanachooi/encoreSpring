package com.example.encoreSpring;

import com.example.encoreSpring.domain.BoardRequest;
import com.example.encoreSpring.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;

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
}
