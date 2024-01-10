package by.teachmeskills.lesson39.controller;

import by.teachmeskills.lesson39.dto.UserDto;
import by.teachmeskills.lesson39.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/management")
public class ManagementUserController {

    private final UserService userService;

    @PostMapping
    public String create(UserDto userDto) {
        userService.create(userDto);
        return "redirect:/";
    }

    @PutMapping//(consumes = "application/json")
    public String update(UserDto userDto) {
//    public String update(@RequestBody UserDto userDto) {
        userService.update(userDto);
        return "redirect:/";
    }

    @DeleteMapping
    public String delete(@RequestParam Long id) {
        userService.remove(id);
        return "redirect:/";
    }

    @GetMapping
    public String findById(@RequestParam Long id, Model model) {
        Optional<UserDto> user = userService.findById(id);
        user.ifPresent(it -> model.addAttribute("user", it));
        return "user";
    }
}
