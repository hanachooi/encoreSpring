package com.example.encoreSpring.mapper;
/*
encore_board_tbl과 CRUD 작업을 위한 추상메서드 선언
Mapper는 기존의 DAO 와 동일한 작업을 진행하는 것
DAO -> DB 드라이버 실행해서, SQL 문 가지고 값을 처리 하는 부분.
*/

import com.example.encoreSpring.domain.BoardRequest;
import com.example.encoreSpring.domain.BoardResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// 각 Mapper를 만들 후에, xml 파일에 등록하기
// 기존의 DAO 의 작업을 대신하고 있다.
// XML 파일을 Mapper를 통해서, 실행하고 있음.
// encore_board_tbl과 CRUD 작업을 위한 추상메서드 선언
/// 추상 메서드의 함수와 xml 파일의 idx 값이 동일해야지, xml 함수 실행이 가능하다.
@Mapper
public interface BoardMapper {

    // insert
    public void save(BoardRequest request);
    // select ( single finder )
    public BoardResponse findByIdx(BoardRequest params);
    // delete ( idx )
    public void deleteByIdx(BoardRequest params);

    // update ( title, content, writer ) - idx
    public void updateById(BoardRequest params);

    // 레코드 건수를 count
    public int count();

    // select (multi finder)
    public List<BoardResponse> findAll();
}
