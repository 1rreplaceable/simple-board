package com.example.simpleboard.controller;

import com.example.simpleboard.entity.User;
import com.example.simpleboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        System.out.println("login!!!");
        return "users/login";
    }

    @GetMapping("/signup")
    public String signup(@ModelAttribute("user") User user) {
        System.out.println("signup!!!");
        return "users/signup";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        if (user.getUsername().length() < 4 || user.getUsername().length() > 20) {
            redirectAttributes.addFlashAttribute("signupError", "아이디는 최소 4자 이상, 최대 20자 이하이어야 합니다.");
            return "redirect:/signup";
        }
        if (!user.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            redirectAttributes.addFlashAttribute("signupError", "올바른 이메일 주소 형식이 아닙니다.");
            return "redirect:/signup";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("signupSuccess", "회원가입이 성공적으로 완료되었습니다.");
        return "redirect:/login";
    }
}
