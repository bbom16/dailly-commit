package com.hackday.dailycommit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/userform")
    public String showUserForm(ModelMap modelMap){
        return "userForm";
    }
}
