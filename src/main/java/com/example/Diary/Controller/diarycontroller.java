package com.example.Diary.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class diarycontroller {
    @GetMapping("/get")
    public String getTest(){
        return "success";
    }
}
