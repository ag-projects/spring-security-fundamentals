package com.agharibi.springsecurity.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return("<h2>Welcome to Spring Security!</h2>");
    }

    @GetMapping("/user")
    public String userHome() {
        String userName = getLoggedInUserName();
        return("<h2>Welcome " + userName + " to the Spring Security demo!</h2>");
    }

    @GetMapping("/admin")
    public String adminHome() {
        String adminName = getLoggedInUserName();
        return("<h2>Welcome " + adminName + " to the Spring Security demo!</h2>");
    }

    private String getLoggedInUserName() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
            .getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

}
