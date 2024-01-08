package by.teachmeskills.lesson41.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static by.teachmeskills.lesson41.util.Profiles.LOCAL;

@Controller
@Profile(LOCAL)
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

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("testText", "Hello!");
        return "test";
    }
}
