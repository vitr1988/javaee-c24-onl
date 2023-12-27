package by.teachmeskills.lesson39.controller;

import by.teachmeskills.lesson39.model.User;
import by.teachmeskills.lesson39.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j
@Controller//@Component
@RequiredArgsConstructor
@RequestMapping("/") // http://localhost:8080/
public class HelloWorldController {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    private final UserService userService;

//    @RequestMapping(value = {"/hello", "/hello/{name}"}, method = RequestMethod.GET)
    @GetMapping({"/hello", "/hello/{name}"}) // http://localhost:8080/hello или http://localhost:8080/hello/Vasya
    public String page(Model model,
                       @PathVariable(value = "name", required = false) String userName,
                       @CookieValue(value = "JSESSIONID", required = false) String jsessionId,
                       @RequestHeader(value = "Authorization", required = false) String authorization) {
        model.addAttribute("userName", StringUtils.isEmpty(userName) ? "Vitaly" : userName);
        return "helloWorld";
    }

    //    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @PostMapping("/hello")
    public String registration(User user) {
        log.info(user);
        return "successfulRegistration";
    }
}
