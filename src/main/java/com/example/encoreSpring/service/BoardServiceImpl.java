package com.example.encoreSpring.service;

import com.example.encoreSpring.domain.BoardRequest;
import com.example.encoreSpring.domain.BoardResponse;
import com.example.encoreSpring.mapper.BoardMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// BoardService boardServiceImpl = new BoardServiceImpl(); 와 @Service와 같게 된다.
@Service("board")
@RequiredArgsConstructor
// 필요한 생성자를 자동으로 의존성 주입 해줌 -> @Autowired 를 제거하고, final 을 붙이게 함.
// 생성자도 자동으로 주입하므로, public void BoardServiceImpl(BoardMapper mapper)가 필요가 없게 됌.
public class BoardServiceImpl implements BoardService {

    /*
    @Autowired
    private BoardMapper boardMapping;
    */

    // service에 dao=orm=mapper를 의존성 주입하게 됌.
    private final BoardMapper boardMapper;

    @Override
    public Integer saveBoard(BoardRequest params) {
        System.out.println("debug >>>> service saveBoard : " + boardMapper);
        boardMapper.save(params);
        return params.getIdx();
    }

    @Override
    public BoardResponse findBoard(BoardRequest params) {

        System.out.println("debug >>>> service findBoard : " + boardMapper);
        BoardResponse response = boardMapper.findByIdx(params);
        return response;
    }

    // 보통, SQL 의 업데이트가 일어나게 되면, @Transactional 을 거는 것이 좋다.
    @Transactional
    @Override
    public void updateBoard(BoardRequest params) {
        System.out.println("debug >>>> service findBoard : " + boardMapper);
        boardMapper.updateById(params);
        // 만약, return 값이 Integer이 되게 된다면, return params.getIdx()로 해주면 된다.
    }

    @Override
    public void deleteBoard(BoardRequest params) {
        System.out.println("debug >>>> service findBoard : " + boardMapper);
        boardMapper.deleteByIdx(params);
    }

    @Override
    public List<BoardResponse> listBoard() {
        System.out.println("debug >>>> service findBoard : " + boardMapper);
        List<BoardResponse> list = boardMapper.findAll();
        return list;
    }

    @Override
    public Integer cntBoard() {
        System.out.println("debug >>> service count Board : " + boardMapper);
        return boardMapper.count();
    }


}
