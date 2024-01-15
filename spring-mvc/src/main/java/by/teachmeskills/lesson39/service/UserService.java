package by.teachmeskills.lesson39.service;

import by.teachmeskills.lesson39.dto.UserDto;

import java.util.Optional;

public interface UserService {
    String name();

    String generateName(Long id);

    void registration(String login, String password, String email, Integer age);

    void create(UserDto userDto);
    void update(UserDto userDto);
    void remove(Long id);

    Optional<UserDto> findById(Long id);

    void createNewUser();
}
