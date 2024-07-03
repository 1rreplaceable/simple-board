package com.example.simpleboard.controller;

import com.example.simpleboard.entity.Board;
import com.example.simpleboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardService.getAllBoards();
        model.addAttribute("boards", boards);
        return "boards/list";
    }
}
