package by.teachmeskills.lesson46.controller;

import by.teachmeskills.lesson46.dto.UserDto;
import by.teachmeskills.lesson46.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @ResponseBody
    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getById(@PathVariable("userId") Long id) {
        Optional<UserDto> result = userService.getById(id);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        if (userDto.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-UniqueHeader", UUID.randomUUID().toString());
        return new ResponseEntity<>(
                userService.create(userDto),
                httpHeaders,
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        if (!Objects.equals(id, userDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Optional<UserDto> result = userService.getAll().stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst();
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        UserDto response = result.get();
        if (!StringUtils.isEmpty(userDto.getName())) {
            response.setName(userDto.getName());
        }
        if (!StringUtils.isEmpty(userDto.getLastName())) {
            response.setLastName(userDto.getLastName());
        }
        if (!StringUtils.isEmpty(userDto.getLogin())) {
            response.setLogin(userDto.getLogin());
        }
        userService.update(id, response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
