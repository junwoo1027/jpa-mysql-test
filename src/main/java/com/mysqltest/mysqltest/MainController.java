package com.mysqltest.mysqltest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("login")
    public String home() {
        return "login";
    }

    @GetMapping("/home")
    public String home(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        String account = (String)session.getAttribute("account");
        model.addAttribute("id", account);

        return "home";
    }
}

@Data
class loginReq {

    private String userId;
    private String password;
}
