// BoardService.java

package com.example.simpleboard.service;

import com.example.simpleboard.entity.Board;

import java.util.List;

public interface BoardService {

    List<Board> getAllBoards();

    Board getBoardById(Long id);

    void saveBoard(Board board);

    void deleteBoardById(Long id);
}
