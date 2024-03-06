package com.example.encoreSpring.service;

import com.example.encoreSpring.domain.BoardRequest;
import com.example.encoreSpring.domain.BoardResponse;
import com.example.encoreSpring.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public Integer saveBoard(BoardRequest params) {
        System.out.println("debug >>>> service saveBoard : " + params);
        return null;
    }

    @Override
    public BoardResponse findBoard(BoardRequest params) {
        return null;
    }

    @Override
    public void updateBoard(BoardRequest params) {
    }

    @Override
    public void deleteBoard(BoardRequest params) {
    }

    @Override
    public List<BoardResponse> listBoard() {
        return null;
    }

    @Override
    public Integer cntBoard() {
        return null;
    }


}
