package com.fis.controller;

import com.fis.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @RequestMapping("/")
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @RequestMapping("/name")
    public ModelAndView namePage() {
        ModelAndView modelAndView = new ModelAndView("name");
        return modelAndView;
    }
    @GetMapping("/contact")
    public ModelAndView contactPage() {
        ModelAndView modelAndView = new ModelAndView("contact");
        modelAndView.addObject("user1", new User());
        return modelAndView;
    }
    @PostMapping("/sendMessage")
    public ModelAndView userContactMessage(User user) {
        ModelAndView modelAndView = new ModelAndView("responsePage");
        modelAndView.addObject("response", user.toString());
        return modelAndView;
    }
}
