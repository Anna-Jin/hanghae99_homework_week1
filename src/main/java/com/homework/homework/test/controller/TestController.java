package com.homework.homework.test.controller;

import com.homework.homework.test.domain.Test;
import com.homework.homework.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public List<Test> getTest() {

        return testService.getTest();
    }

    @PostMapping("/test")
    public String addTest() {

        testService.addTest();

        return "성공";
    }
}
