package com.personal.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("title","Web Shopping");

        return "index";
    }

}
