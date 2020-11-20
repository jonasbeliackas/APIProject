package com.example.demo.controller;

import com.example.demo.dao.CurrentWeatherData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {

    @GetMapping("/")
    public String goToIndex()
    {
        return "index";
    }
    /*@GetMapping("/Today")
    public String goToToday()
    {
        return "today";
    }*/
    @GetMapping("/Week")
    public String goToWeek()
    {
        return "week";
    }
    @GetMapping("/30Days")
    public String go30Days()
    {
        return "30days";
    }

}
