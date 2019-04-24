package com.zxkj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/{index}")
    public String index(@PathVariable("index") String index){
        return index;
    }
}
