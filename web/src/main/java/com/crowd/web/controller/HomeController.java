package com.crowd.web.controller;

import com.crowd.web.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by luis on 2017/6/29.
 */
@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private UserClient userClient;

    @GetMapping("index")
    public void index(HttpServletResponse response){
        try {
            PrintWriter out = response.getWriter();
            out.println(userClient.getIndex());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
