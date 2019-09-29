package com.hackday.dailycommit.Commit.controller;

import com.hackday.dailycommit.Commit.dto.TodayCommit;
import com.hackday.dailycommit.Commit.service.CommitService;

import com.hackday.dailycommit.Commit.service.TodayCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CommitController {

    @Autowired
    CommitService commitService;

    @Autowired
    TodayCommitService todayCommitService;

    @GetMapping("/")
    public String showMain(ModelMap modelMap){
        List<TodayCommit> todayCommits = todayCommitService.getTodayCommits();
        modelMap.addAttribute("todayCommits", todayCommits);
        return "mainPage";
    }
    @Scheduled(cron = "0 0 19 * * ?")
    public void checkDaillyCommit(){
        commitService.insertCommit();
    }

}
