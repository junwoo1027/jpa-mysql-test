package com.mysqltest.mysqltest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class ApiController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/loginaccount")
    public Account login(@RequestBody loginReq loginReq, HttpServletRequest req) {
        Account account = accountRepository.findById(loginReq.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("no user")
        );

        HttpSession session = req.getSession();

        session.setAttribute("account", account.getUserId());

        return account;
    }
}
