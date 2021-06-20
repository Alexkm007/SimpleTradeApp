package ru.sta.simpletradeapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @RequestMapping()
    public String getWelcome(){
        return "Welcome to  simple trade app, api doc https://github.com/Alexkm007/SimpleTradeApp";
    }

}
