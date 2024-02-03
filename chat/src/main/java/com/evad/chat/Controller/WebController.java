package com.evad.chat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class WebController {

    @GetMapping
    public String showMainPage(){
        return "index";
    }
}
