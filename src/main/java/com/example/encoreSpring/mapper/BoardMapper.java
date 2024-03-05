package com.example.encoreSpring.mapper;
/*
encore_board_tbl과 CRUD 작업을 위한 추상메서드 선언
Mapper는 기존의 DAO 와 동일한 작업을 진행하는 것
DAO -> DB 드라이버 실행해서, SQL 문 가지고 값을 처리 하는 부분.
*/

import com.example.encoreSpring.domain.BoardRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

// 각 Mapper를 만들 후에, xml 파일에 등록하기
@Mapper
public interface BoardMapper {

    public void save(BoardRequest request);

}
