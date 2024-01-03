package by.teachmeskills.lesson41.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "helloWorld";
    }


    @GetMapping("/another-hello")
    public String anotherHelloWorld() {
        return "anotherHelloWorld";
    }

    @GetMapping("/another-hello2")
    public String anotherHelloWorld2() {
        return "anotherHelloWorld";
    }
}
