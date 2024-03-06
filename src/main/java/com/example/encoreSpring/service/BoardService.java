package com.example.encoreSpring.service;

import com.example.encoreSpring.domain.BoardRequest;
import com.example.encoreSpring.domain.BoardResponse;
import java.util.List;

public interface BoardService {

    public Integer saveBoard(BoardRequest params);

    public BoardResponse findBoard(BoardRequest params);

    public void updateBoard(BoardRequest params);

    public void deleteBoard(BoardRequest params);

    public List<BoardResponse> listBoard();

    public Integer cntBoard();
}
