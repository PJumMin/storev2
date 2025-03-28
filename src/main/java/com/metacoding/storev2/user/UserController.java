package com.metacoding.storev2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    // MainPage
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // joinPage
    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }

    // join
    @PostMapping("/join")
    public String join(UserRequest.JoinDTO joinDTO) {
        userService.join(joinDTO);
        return "redirect:login-form";
    }

    // loginPage
    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }
}
