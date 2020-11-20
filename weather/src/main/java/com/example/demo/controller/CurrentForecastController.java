package com.example.demo.controller;

import com.example.demo.dao.CurrentWeatherData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CurrentForecastController {
    /*@RequestMapping(value = "/today", method = RequestMethod.GET)
    public String convertGet(@ModelAttribute("convert") Converter converter, Model model)
    {
        model.addAttribute("convertedValue",(double)0);
        model.addAttribute("currency",repo.findAll());
        return "converter";
    }
    @RequestMapping(value = "/today", method = RequestMethod.POST)
    public String convertPost(@ModelAttribute("convert") Converter converter,Model model)
    {
        model.addAttribute("currency",repo.findAll());

        model.addAttribute("convertedValue",converter.convertToEur());
        return "converter";
    }*/
    @RequestMapping(value = "/today",method = RequestMethod.GET)
    public String todayGet(@ModelAttribute("currentData")CurrentWeatherData currentData,Model model)
    {
        currentData.sendApiRequest();
        model.addAttribute("temp",currentData.getTemp());
        model.addAttribute("name",currentData.getCity_name());
        model.addAttribute("date",currentData.getDatetime());
        model.addAttribute("desc",currentData.getDescription());
        currentData.setLocation("");
       System.out.println("get");
        return "today";
    }
    @RequestMapping(value = "/today",method = RequestMethod.POST)
    public String todayPost(@ModelAttribute("currentData")CurrentWeatherData currentData,Model model)
    {
        currentData.sendApiRequest();
        model.addAttribute("temp",currentData.getTemp());
        model.addAttribute("name",currentData.getCity_name());
        model.addAttribute("date",currentData.getDatetime());
        model.addAttribute("desc",currentData.getDescription());
        currentData.setLocation("");
        System.out.println("post");
        return "today";
    }

}
