package by.teachmeskills.lesson46.controller;

import by.teachmeskills.lesson46.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    @GetMapping("/reg")
    public String registrationPage(@ModelAttribute("user") User user) {
//        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/reg")
    public String registrationProcessing(@Valid User user, BindingResult result) {
//        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
//        if (!constraintViolations.isEmpty()) {
//            return "registration";
//        }
//        return "redirect:/";

        if (!result.hasErrors()) {
            return "registration";
        }
        log.info("User {}", user);
        return "redirect:/";
    }
}
