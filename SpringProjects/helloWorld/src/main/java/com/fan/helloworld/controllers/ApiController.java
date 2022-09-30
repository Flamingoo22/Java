package com.fan.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiController {

//        @RequestMapping("")
//        public String apiTest() {
//            return "index.jsp";
//        }
        
        @RequestMapping("/")
        public String index(Model model) {
            model.addAttribute("dojoName", "Burbank");
            return "index.jsp";
        }
        }
 

}
