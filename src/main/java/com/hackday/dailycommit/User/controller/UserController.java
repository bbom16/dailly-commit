package com.hackday.dailycommit.User.controller;

import com.hackday.dailycommit.User.dto.User;
import com.hackday.dailycommit.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/add/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public String insertUser(@ModelAttribute User newUser, RedirectAttributes redirectAttributes){
        User user = userService.insertUser(newUser);
        System.out.println(user);

        if(user == null){
            redirectAttributes.addFlashAttribute("message", "github 아이디를 확인해주세요. 존재하지않는 아이디입니다.");
            return "redirect:/userform";
        }
        if(user.getId() == null) {
            redirectAttributes.addFlashAttribute("message", "이미 등록된 아이디입니다. 다시 확인해주세요");
            return "redirect:/userform";
        }

        return "redirect:/";
    }
}
