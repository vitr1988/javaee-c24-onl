package by.teachmeskills.lesson39.controller;

import by.teachmeskills.lesson39.model.User;
import by.teachmeskills.lesson39.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Log4j
@Validated
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/reg")
    public String registration() {
        return "registration";
    }

    @PostMapping("/reg")
    public String register(Model model, @Valid @ModelAttribute User user, BindingResult result) {
//        if (StringUtils.isEmpty(user.getLogin())  || StringUtils.isEmpty(user.getPassword())) {
//            return "failureRegistration";
//        }
        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            String key = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            switch (key) {
                case "login" -> model.addAttribute("loginErrorLabel", defaultMessage);
                case "password" -> model.addAttribute("passwordErrorLabel", defaultMessage);
                case "email" -> model.addAttribute("emailErrorLabel", defaultMessage);
                case "age" -> model.addAttribute("ageErrorLabel", defaultMessage);
            }
//            model.addAttribute("login", user.getLogin());
//            model.addAttribute("password", user.getPassword());
//            model.addAttribute("age", user.getAge());
//            model.addAttribute("email", user.getEmail());
            return "registration";
        }
        String login = user.getLogin();
//        try {
            userService.registration(login, user.getPassword(), user.getEmail(), user.getAge());
//        } catch (Exception e) {
//            log.error("Exception happens", e);
//            return "failureRegistration";
//        }
        model.addAttribute("login", login);
        return "successfulRegistration";
    }

//    @ExceptionHandler(Exception.class)
//    public String testError(Model model, Exception exception) {
//        model.addAttribute("detailedMessage", exception.getMessage());
//        return "failureRegistration";
//    }

//    @ExceptionHandler(IllegalStateException.class)
//    public String testError(Model model, IllegalStateException exception) {
//        model.addAttribute("detailedMessage", exception.getMessage());
//        return "failureRegistration";
//    }
}