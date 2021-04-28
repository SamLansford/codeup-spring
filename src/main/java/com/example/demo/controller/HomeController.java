package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

public class HomeController {

    @RequestMapping(path = "/add/{number}/and/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int number) {
        return number + " plus four is " + (number + 4);
    }

//    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
//    @ResponseBody
//    public String addOne(@PathVariable int number) {
//        return number + " plus ons is " + (number + 1);
//    }
}
