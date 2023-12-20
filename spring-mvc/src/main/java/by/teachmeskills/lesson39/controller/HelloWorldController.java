package by.teachmeskills.lesson39.controller;

import by.teachmeskills.lesson39.model.User;
import by.teachmeskills.lesson39.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Log4j
@Controller//@Component
@RequiredArgsConstructor
@RequestMapping("/") // http://localhost:8080/
public class HelloWorldController {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    private final UserService userService;

//    @GetMapping("/hello/{name}") // // http://localhost:8080/hello
    @GetMapping("/hello") // // http://localhost:8080/hello
//    public String page(Model model, @PathVariable(value = "name", required = false) String userName) {
    public String page(Model model, @RequestParam(value = "id", required = false) Long userId) {
//        model.addAttribute("userName", StringUtils.isEmpty(userName) ? "Vitaly" : userName);
        model.addAttribute("userName", Objects.isNull(userId) ? "Vitaly" : userService.generateName(userId));
        return "helloWorld";
    }

    @PostMapping("/hello")
    public String registration(User user) {
        log.info(user);
        return "successfulRegistration";
    }
}
