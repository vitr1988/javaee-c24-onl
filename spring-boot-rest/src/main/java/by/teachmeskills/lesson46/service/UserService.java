package by.teachmeskills.lesson46.service;

import by.teachmeskills.lesson46.dto.CreateUserDto;
import by.teachmeskills.lesson46.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    List<UserDto> getAll(Pageable pageable);

    UserDto create(CreateUserDto userDto);

    void update(Long id, UserDto response);

    void deleteById(Long id);

    UserDto getById(Long id);

    List<UserDto> getAllByHttp();

    List<UserDto> findByName(String name);
}
