package by.teachmeskills.lesson46.service;

import by.teachmeskills.lesson46.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto create(UserDto userDto);

    void update(Long id, UserDto response);

    void deleteById(Long id);

    UserDto getById(Long id);

    List<UserDto> getAllByHttp();
}
