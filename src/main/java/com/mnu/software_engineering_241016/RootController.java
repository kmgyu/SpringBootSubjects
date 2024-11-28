package com.mnu.software_engineering_241016;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    //        서블릿 url 패턴
    @GetMapping("/home")
    public String root(Model model) {
        model.addAttribute("value", "fuck");
//        서블릿에서 하는일\
        return "hello_world.html";
    }

    @GetMapping("/hi")
    public String hi(Model model) {
        return "hello.html";
    }
}
