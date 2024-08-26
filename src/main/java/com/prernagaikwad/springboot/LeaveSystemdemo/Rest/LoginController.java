package com.prernagaikwad.springboot.LeaveSystemdemo.Rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Return the login.html view
    }
}
