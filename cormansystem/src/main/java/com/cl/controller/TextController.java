package com.cl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by one on 2018/4/20.
 */
@Controller
public class TextController {

    @RequestMapping("/login")
    private String text()throws  Exception{
        return "success";
    }
}
