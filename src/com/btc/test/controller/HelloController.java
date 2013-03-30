package com.btc.test.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 */
@Controller
public class HelloController {
 
    @RequestMapping("/hello")
    public void test(HttpServletResponse response) throws IOException {
        response.getWriter().write("Hi, u guy.");
    }
}