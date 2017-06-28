package com.crowd.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luis on 2017/6/29.
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("index")
    public String index(){
        return "11222222222";
    }
}
