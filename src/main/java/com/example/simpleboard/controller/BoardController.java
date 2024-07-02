package com.example.simpleboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("boards/list OK!");
        return "boards/list"; // templates/boards/list.html을 참조합니다.
    }
}
