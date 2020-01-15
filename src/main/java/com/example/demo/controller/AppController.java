package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController {

    @GetMapping("/default")
    public ModelAndView defaultAfterLogin(HttpServletRequest request) {
        System.out.println(request.getRemoteUser());

        System.out.println(request.isUserInRole("ADMIN"));
        System.out.println(request.isUserInRole("CLIENT"));
        System.out.println(request.isUserInRole("USER"));
        if (request.isUserInRole("ADMIN")) {
            return new ModelAndView("redirect:/author/edit_author");
        }
        return new ModelAndView("redirect:/user");
    }


    @GetMapping({"/", "/login"})
    public String index() {
        return "index";
    }
}

