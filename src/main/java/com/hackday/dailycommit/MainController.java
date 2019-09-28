package com.hackday.dailycommit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String showMain(){
        return "mainPage";
    }

    @GetMapping("/userform")
    public String showUserForm(ModelMap modelMap){
        return "userForm";
    }
}
