package by.teachmeskills.lesson39.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrinterController {

    @PostMapping("/print")
    public ModelAndView print() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("helloWorld");
        modelAndView.addObject("userName", "everyone!");
//        modelAndView.addObject("userName", "everyone!");
//        modelAndView.addObject("userName", "everyone!");
//        modelAndView.addObject("userName", "everyone!");
//        modelAndView.addObject("userName", "everyone!");
        return modelAndView;
    }
}
