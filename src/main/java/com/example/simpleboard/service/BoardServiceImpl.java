package com.example.simpleboard.service;

import com.example.simpleboard.entity.Board;
import com.example.simpleboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    public Board getBoardById(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        return board.orElse(null);
    }

    @Override
    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void deleteBoardById(Long id) {
        boardRepository.deleteById(id);
    }
}
